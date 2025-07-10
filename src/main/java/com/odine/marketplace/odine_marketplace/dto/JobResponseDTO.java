package com.odine.marketplace.odine_marketplace.dto;

import com.odine.marketplace.odine_marketplace.model.JobStatus;

import java.time.LocalDateTime;

public record JobResponseDTO(
        Long id,
        Long freelancerId,
        LocalDateTime createdDate,
        JobStatus status,
        String description
) {}
