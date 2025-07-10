// service/CommentService.java
package com.odine.marketplace.odine_marketplace.service;

import com.odine.marketplace.odine_marketplace.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    CommentResponseDTO create(CommentRequestDTO dto);
    Page<CommentResponseDTO> listByJob(Long jobId, Pageable p);
    CommentResponseDTO update(Long id, CommentRequestDTO dto);
}
