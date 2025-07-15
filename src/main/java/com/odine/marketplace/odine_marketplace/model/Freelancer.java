package com.odine.marketplace.odine_marketplace.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "freelancers")
public class Freelancer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String city;

    @Enumerated(EnumType.STRING)
    private FreelancerType type;

    private String portfolioUrl;

    @ElementCollection
    private List<String> designTools = new ArrayList<>();

    @ElementCollection
    private List<String> languages = new ArrayList<>();

    @ElementCollection
    private List<String> specialties = new ArrayList<>();

    private int evaluationScore;   // 1‒10

    public Freelancer() {
    }


   /* public Freelancer(String name, String email, String phone, String city,
                      FreelancerType type,
                      String portfolioUrl,
                      List<String> designTools,
                      List<String> languages,
                      List<String> specialties) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.type = type;
        this.portfolioUrl = portfolioUrl;
        if (designTools != null)   this.designTools = designTools;
        if (languages   != null)   this.languages   = languages;
        if (specialties != null)   this.specialties = specialties;
    }
*/
    /* ---------- Getter / Setter’lar ---------- */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public FreelancerType getType() { return type; }
    public void setType(FreelancerType type) { this.type = type; }

    public String getPortfolioUrl() { return portfolioUrl; }
    public void setPortfolioUrl(String portfolioUrl) { this.portfolioUrl = portfolioUrl; }

    public List<String> getDesignTools() { return designTools; }
    public void setDesignTools(List<String> designTools) { this.designTools = designTools; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public List<String> getSpecialties() { return specialties; }
    public void setSpecialties(List<String> specialties) { this.specialties = specialties; }

    public Integer getEvaluationScore() { return evaluationScore; }
    public void setEvaluationScore(Integer evaluationScore) { this.evaluationScore = evaluationScore; }

    /* ---------- yardımcı ---------- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freelancer that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Freelancer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
