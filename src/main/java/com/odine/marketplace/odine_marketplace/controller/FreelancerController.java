package com.odine.marketplace.odine_marketplace.controller;

import com.odine.marketplace.odine_marketplace.dto.*;
import com.odine.marketplace.odine_marketplace.service.FreelancerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/freelancers")
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerService service;

    @PostMapping
    public FreelancerResponseDTO create(@Valid @RequestBody FreelancerRequestDTO dto) {
        return service.create(dto);
    }


    @GetMapping
    public Page<FreelancerResponseDTO> list(
            @PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {

        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public FreelancerResponseDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/search")
    public Page<FreelancerResponseDTO> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String tool,
            @RequestParam(required = false) String specialty,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable p = PageRequest.of(page, size);
        return service.search(name, city, tool, specialty, p);
    }

    /* yardımcı */
    private Sort.Order[] parseSort(String[] sort) {
        // "name,asc"
        return java.util.Arrays.stream(sort)
                .map(s -> {
                    String[] split = s.split(",");
                    return new Sort.Order(
                            split.length > 1 && "desc".equalsIgnoreCase(split[1])
                                    ? Sort.Direction.DESC : Sort.Direction.ASC,
                            split[0]);
                }).toArray(Sort.Order[]::new);
    }
}
