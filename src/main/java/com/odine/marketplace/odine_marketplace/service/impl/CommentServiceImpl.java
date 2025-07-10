// service/impl/CommentServiceImpl.java
package com.odine.marketplace.odine_marketplace.service.impl;

import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.mapper.CommentMapper;
import com.odine.marketplace.odine_marketplace.model.Comment;
import com.odine.marketplace.odine_marketplace.model.Job;
import com.odine.marketplace.odine_marketplace.repository.CommentRepository;
import com.odine.marketplace.odine_marketplace.repository.JobRepository;
import com.odine.marketplace.odine_marketplace.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepo;
    private final JobRepository jobRepo;
    private final CommentMapper mapper;

    @Override @Transactional
    public CommentResponseDTO create(CommentRequestDTO dto) {
        //createdDate create edildikten sonra null dönüyor.
        Job job = jobRepo.findById(dto.jobId())
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
        Comment saved = commentRepo.save(mapper.toEntity(dto, job));
        return mapper.toDto(saved);
    }



    @Override
    public Page<CommentResponseDTO> listByJob(Long jobId, Pageable p) {
        return commentRepo.findByJobId(jobId, p).map(mapper::toDto);
    }

    @Override @Transactional
    public CommentResponseDTO update(Long id, CommentRequestDTO dto) {
        Comment c = commentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        // sadece yorum metni güncellensin; job & commenter değişmiyor
        c.setCommentText(dto.commentText());
        return mapper.toDto(commentRepo.save(c));
    }
}
