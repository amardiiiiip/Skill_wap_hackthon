package com.swapplatform.repository;

import com.swapplatform.entity.SkillWanted;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillWantedRepository extends JpaRepository<SkillWanted, Long> {
    List<SkillWanted> findByNameContainingIgnoreCase(String query);
}