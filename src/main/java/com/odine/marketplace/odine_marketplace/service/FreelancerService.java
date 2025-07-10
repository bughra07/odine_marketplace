package com.odine.marketplace.odine_marketplace.service;


import com.odine.marketplace.odine_marketplace.dto.*;
import org.springframework.data.domain.*;

public interface FreelancerService {
    FreelancerResponseDTO create(FreelancerRequestDTO dto);
    Page<FreelancerResponseDTO> list(Pageable pageable);
    FreelancerResponseDTO get(Long id);
    Page<FreelancerResponseDTO> search(
            String name, String city, String tool, String spec, Pageable pageable);
}
