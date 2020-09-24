package com.example.demo.repository;

import com.example.demo.domain.entity.TraineeDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<TraineeDo, Long> {
}
