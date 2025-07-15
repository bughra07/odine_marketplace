package com.odine.marketplace.odine_marketplace.service.impl;

import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.model.*;
import com.odine.marketplace.odine_marketplace.repository.FreelancerRepository;
import com.odine.marketplace.odine_marketplace.service.*;
import com.odine.marketplace.odine_marketplace.spec.FreelancerSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    private final FreelancerRepository repo;

    @Override @Transactional
    public FreelancerResponseDTO create(FreelancerRequestDTO dto) {
        Freelancer f = FreelancerMapper.toEntity(dto);
        repo.save(f);                 // id oluştu
        evaluateAsync(f.getId());     // puan hesaplama arkada
        return FreelancerMapper.toDto(f);
    }

    @Async
    void evaluateAsync(Long id) {
        repo.findById(id).ifPresent(f -> {
            int score;
            if (f.getType() == FreelancerType.DESIGNER) {
                score = (f.getDesignTools() == null) ? 0 : f.getDesignTools().size();
            } else {
                int langs = f.getLanguages() == null ? 0 : f.getLanguages().size();
                int specs = f.getSpecialties() == null ? 0 : f.getSpecialties().size();
                score = langs * specs;
            }
            score = Math.max(1, Math.min(10, score));
            f.setEvaluationScore(score);
            repo.save(f);
        });
    }

    @Override
    public Page<FreelancerResponseDTO> list(Pageable p) {
        return repo.findAll(p).map(FreelancerMapper::toDto);
    }

    @Override
    public FreelancerResponseDTO get(Long id) {
        return repo.findById(id)
                .map(FreelancerMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Freelancer "+id+" not found"));
    }

    @Override
    public Page<FreelancerResponseDTO> search(
            String name, String city, String tool, String spec, Pageable pageable) {

        Specification<Freelancer> specAll = Specification
                .where(FreelancerSpecifications.hasName(name))
                .and(FreelancerSpecifications.hasCity(city))
                .and(FreelancerSpecifications.hasType(null))   // type filtreyi istersen ekle
                .and(FreelancerSpecifications.hasDesignTool(tool))
                .and(FreelancerSpecifications.hasSpecialty(spec));

        return repo.findAll(specAll, pageable).map(FreelancerMapper::toDto);
    }
}
