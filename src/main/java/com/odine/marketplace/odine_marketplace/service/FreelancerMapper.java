package com.odine.marketplace.odine_marketplace.service;


import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.model.Freelancer;

public final class FreelancerMapper {

    public static Freelancer toEntity(FreelancerRequestDTO dto) {
        Freelancer f = new Freelancer();
        f.setName(dto.name());
        f.setEmail(dto.email());
        f.setPhone(dto.phone());
        f.setCity(dto.city());
        f.setType(dto.type());
        f.setPortfolioUrl(dto.portfolioUrl());
        f.setDesignTools(dto.designTools());
        f.setLanguages(dto.languages());
        f.setSpecialties(dto.specialties());
        return f;
    }

    public static FreelancerResponseDTO toDto(Freelancer f) {
        return new FreelancerResponseDTO(
                f.getId(), f.getName(), f.getEmail(), f.getPhone(), f.getCity(),
                f.getType(), f.getPortfolioUrl(), f.getDesignTools(),
                f.getLanguages(), f.getSpecialties(), f.getEvaluationScore()
        );
    }

    private FreelancerMapper() {}
}
