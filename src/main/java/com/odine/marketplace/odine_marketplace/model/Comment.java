// src/main/java/com/odine/marketplace/odine_marketplace/model/Comment.java
package com.odine.marketplace.odine_marketplace.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Comment {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private String commenterName;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(columnDefinition = "text")
    private String commentText;
}
