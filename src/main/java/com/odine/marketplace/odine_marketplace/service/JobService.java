package com.odine.marketplace.odine_marketplace.service;

import com.odine.marketplace.odine_marketplace.dto.JobRequestDTO;
import com.odine.marketplace.odine_marketplace.dto.JobResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    JobResponseDTO create(JobRequestDTO dto);
    JobResponseDTO get(Long id);
    Page<JobResponseDTO> jobsOfFreelancer(Long freelancerId, Pageable p);
    JobResponseDTO update(Long id, JobRequestDTO dto);
}
