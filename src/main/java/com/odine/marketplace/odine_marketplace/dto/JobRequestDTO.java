package com.odine.marketplace.odine_marketplace.dto;

import com.odine.marketplace.odine_marketplace.model.JobStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/** POST için freelancerId & description zorunlu — PATCH’te sadece değişen alanlar gelir. */
public record JobRequestDTO(
        @NotNull Long freelancerId,
        @NotBlank String description,
        JobStatus status          // PATCH çağrısında opsiyonel şekilde gelebilir
) {}
