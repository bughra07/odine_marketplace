package com.odine.marketplace.odine_marketplace.dto;
import com.odine.marketplace.odine_marketplace.model.FreelancerType;
import java.util.List;

public record FreelancerResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String city,
        FreelancerType type,
        String portfolioUrl,
        List<String> designTools,
        List<String> languages,
        List<String> specialties,
        Integer evaluationScore
) {}
