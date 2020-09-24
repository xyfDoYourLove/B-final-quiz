package com.example.demo.repository;

import com.example.demo.domain.entity.TraineeDo;
import com.example.demo.domain.entity.TrainerDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<TrainerDo, Long> {

  List<TrainerDo> findAllByGroupedOrderByIdAsc(boolean grouped);

}
