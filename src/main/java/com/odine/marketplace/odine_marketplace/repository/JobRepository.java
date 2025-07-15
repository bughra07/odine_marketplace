package com.odine.marketplace.odine_marketplace.repository;

import com.odine.marketplace.odine_marketplace.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

    Page<Job> findByFreelancer_Id(Long freelancerId, Pageable pageable);
}
