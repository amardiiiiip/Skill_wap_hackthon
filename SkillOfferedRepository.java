package com.swapplatform.repository;

import com.swapplatform.entity.SkillOffered;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillOfferedRepository extends JpaRepository<SkillOffered, Long> {
    List<SkillOffered> findByNameContainingIgnoreCase(String query);
}