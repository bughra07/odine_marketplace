// repository/CommentRepository.java
package com.odine.marketplace.odine_marketplace.repository;

import com.odine.marketplace.odine_marketplace.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByJobId(Long jobId, Pageable pageable);
}
