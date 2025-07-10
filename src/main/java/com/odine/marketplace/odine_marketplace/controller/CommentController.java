// controller/CommentController.java
package com.odine.marketplace.odine_marketplace.controller;

import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService service;

    /* 1) create */
    @PostMapping("/comments")
    public CommentResponseDTO create(@Valid @RequestBody CommentRequestDTO dto) {
        return service.create(dto);
    }

    /* 2) read comments of a job */
    @GetMapping("/jobs/{jobId}/comments")
    public Page<CommentResponseDTO> listByJob(@PathVariable Long jobId,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "20") int size) {
        return service.listByJob(jobId, PageRequest.of(page, size, Sort.by("createdDate").descending()));
    }

    /* 3) update comment text */
    @PatchMapping("/comments/{id}")
    public CommentResponseDTO update(@PathVariable Long id,
                                     @Valid @RequestBody CommentRequestDTO dto) {
        return service.update(id, dto);
    }
}
