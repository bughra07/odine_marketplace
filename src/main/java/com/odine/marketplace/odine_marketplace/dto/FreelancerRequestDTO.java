package com.odine.marketplace.odine_marketplace.dto;



import com.odine.marketplace.odine_marketplace.model.FreelancerType;
import jakarta.validation.constraints.*;
import java.util.List;

public record FreelancerRequestDTO(
        @NotBlank String name,
        @Email     String email,
        @Pattern(regexp="\\+?\\d{10,15}") String phone,
        @NotBlank String city,
        @NotNull  FreelancerType type,

        String portfolioUrl,
        List<String> designTools,


        List<String> languages,
        List<String> specialties
) {}
