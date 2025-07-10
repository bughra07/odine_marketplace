package com.odine.marketplace.odine_marketplace.service.impl;

import com.odine.marketplace.odine_marketplace.dto.JobRequestDTO;
import com.odine.marketplace.odine_marketplace.dto.JobResponseDTO;
import com.odine.marketplace.odine_marketplace.mapper.JobMapper;
import com.odine.marketplace.odine_marketplace.model.Freelancer;
import com.odine.marketplace.odine_marketplace.model.Job;
import com.odine.marketplace.odine_marketplace.repository.FreelancerRepository;
import com.odine.marketplace.odine_marketplace.repository.JobRepository;
import com.odine.marketplace.odine_marketplace.service.JobService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobServiceImpl implements JobService {

    private final JobRepository repo;
    private final FreelancerRepository freelancerRepo;

    @Override
    public JobResponseDTO create(JobRequestDTO dto) {
        Freelancer f = freelancerRepo.findById(dto.freelancerId())
                .orElseThrow(() -> new IllegalArgumentException("Freelancer not found"));

        Job job = new Job(f, dto.description());
        // status null ⇒ IN_PROGRESS, ama create sırasında override etmek istersen:
        if (dto.status() != null) job.setStatus(dto.status());

        return JobMapper.toDto(repo.save(job));
    }

    @Override
    @Transactional(readOnly = true)
    public JobResponseDTO get(Long id) {
        return repo.findById(id)
                .map(JobMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JobResponseDTO> jobsOfFreelancer(Long freelancerId, Pageable p) {
        return repo.findByFreelancer_Id(freelancerId, p)
                .map(JobMapper::toDto);
    }

    @Override
    public JobResponseDTO update(Long id, JobRequestDTO dto) {
        Job job = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        if (dto.status() != null)       job.setStatus(dto.status());
        if (dto.description() != null && !dto.description().isBlank())
            job.setDescription(dto.description());

        return JobMapper.toDto(job);    // dirty-checking ile otomatik flush
    }
}
