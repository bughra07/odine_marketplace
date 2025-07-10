package com.odine.marketplace.odine_marketplace.spec;



import com.odine.marketplace.odine_marketplace.model.*;
import org.springframework.data.jpa.domain.Specification;
import java.util.Locale;

public class FreelancerSpecifications {

    public static Specification<Freelancer> hasName(String name) {
        return (root, q, cb) ->
                name == null ? null :
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase(Locale.ROOT) + "%");
    }

    public static Specification<Freelancer> hasCity(String city) {
        return (root, q, cb) ->
                city == null ? null : cb.equal(cb.lower(root.get("city")), city.toLowerCase());
    }

    public static Specification<Freelancer> hasType(FreelancerType type) {
        return (root, q, cb) ->
                type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<Freelancer> hasDesignTool(String tool) {
        return (root, q, cb) ->
                tool == null ? null :
                        cb.isMember(tool, root.get("designTools"));
    }

    public static Specification<Freelancer> hasSpecialty(String spec) {
        return (root, q, cb) ->
                spec == null ? null :
                        cb.isMember(spec, root.get("specialties"));
    }
}
