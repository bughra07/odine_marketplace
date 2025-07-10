// dto/CommentResponseDTO.java
package com.odine.marketplace.odine_marketplace.dto;

import java.time.LocalDateTime;

public record CommentResponseDTO(
        Long id,
        Long jobId,
        String commenterName,
        LocalDateTime createdDate,
        String commentText
) {}
