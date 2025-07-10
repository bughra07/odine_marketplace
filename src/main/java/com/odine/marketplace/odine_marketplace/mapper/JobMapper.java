package com.odine.marketplace.odine_marketplace.mapper;

import com.odine.marketplace.odine_marketplace.dto.JobResponseDTO;
import com.odine.marketplace.odine_marketplace.model.Job;

public class JobMapper {

    private JobMapper() {}      // util class

    public static JobResponseDTO toDto(Job j) {
        return new JobResponseDTO(
                j.getId(),
                j.getFreelancer().getId(),
                j.getCreatedDate(),
                j.getStatus(),
                j.getDescription()
        );
    }
}
