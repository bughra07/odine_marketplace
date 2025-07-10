
package com.odine.marketplace.odine_marketplace.repository;

import com.odine.marketplace.odine_marketplace.model.Freelancer;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FreelancerRepository
        extends JpaRepository<Freelancer, Long>,
        JpaSpecificationExecutor<Freelancer> {

}
