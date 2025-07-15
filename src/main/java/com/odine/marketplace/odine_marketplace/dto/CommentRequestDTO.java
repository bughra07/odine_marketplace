package com.odine.marketplace.odine_marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDTO(
        @NotNull Long jobId,
        @NotBlank String commenterName,
        @NotBlank String commentText
) {}
