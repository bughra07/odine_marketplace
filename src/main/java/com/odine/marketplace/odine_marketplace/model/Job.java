package com.odine.marketplace.odine_marketplace.model;

import jakarta.persistence.*;
        import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Bir freelance iş (proje) kaydı.
 * Freelancer : Many-to-One ilişki • createdDate otomatik dolacak.
 */
@Entity
@Table(name = "jobs")
public class Job {

    /* ---------- Alanlar ---------- */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Freelancer FK – boş olamaz */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer;

    /** Oluşturulduğu an – Hibernate tarafından set edilir, değiştirilemez */
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status = JobStatus.IN_PROGRESS;

    @Column(length = 1000)
    private String description;


    public Job() { }   // JPA için zorunlu

    public Job(Freelancer freelancer,
               String description) {
        this.freelancer = freelancer;
        this.description = description;
        this.status = JobStatus.IN_PROGRESS;
    }


    public Long getId() { return id; }

    public Freelancer getFreelancer() { return freelancer; }
    public void setFreelancer(Freelancer freelancer) { this.freelancer = freelancer; }

    public LocalDateTime getCreatedDate() { return createdDate; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
