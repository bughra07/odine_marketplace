package com.odine.marketplace.odine_marketplace.controller;

import com.odine.marketplace.odine_marketplace.dto.JobRequestDTO;
import com.odine.marketplace.odine_marketplace.dto.JobResponseDTO;
import com.odine.marketplace.odine_marketplace.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {

    private final JobService service;

    /* ---------- 1. Create new job ---------- */
    @PostMapping("/jobs")
    public JobResponseDTO create(@Valid @RequestBody JobRequestDTO dto) {
        return service.create(dto);
    }

    /* ---------- 2. Jobs of a freelancer ---------- */
    @GetMapping("/freelancers/{freelancerId}/jobs")
    public Page<JobResponseDTO> jobsOfFreelancer(@PathVariable Long freelancerId,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "20") int size) {
        Pageable p = PageRequest.of(page, size);
        return service.jobsOfFreelancer(freelancerId, p);
    }

    /* ---------- 3. Get job ---------- */
    @GetMapping("/jobs/{id}")
    public JobResponseDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    /* ---------- 4. Update job ---------- */
    @PatchMapping("/jobs/{id}")
    public JobResponseDTO update(@PathVariable Long id,
                                 @RequestBody JobRequestDTO dto) {
        return service.update(id, dto);
    }
}
