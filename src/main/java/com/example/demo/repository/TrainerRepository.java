package com.example.demo.repository;

import com.example.demo.domain.entity.TrainerDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<TrainerDo, Long> {
}
