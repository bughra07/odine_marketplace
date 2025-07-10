// mapper/CommentMapper.java
package com.odine.marketplace.odine_marketplace.mapper;

import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.model.Comment;
import com.odine.marketplace.odine_marketplace.model.Job;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment toEntity(CommentRequestDTO dto, Job job) {
        return Comment.builder()
                .job(job)
                .commenterName(dto.commenterName())
                .commentText(dto.commentText())
                .build();
    }

    public CommentResponseDTO toDto(Comment entity) {
        return new CommentResponseDTO(
                entity.getId(),
                entity.getJob().getId(),
                entity.getCommenterName(),
                entity.getCreatedDate(),
                entity.getCommentText()
        );
    }
}
