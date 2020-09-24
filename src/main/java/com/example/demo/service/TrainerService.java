package com.example.demo.service;

import com.example.demo.domain.vo.TrainerVo;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

  private final TrainerRepository trainerRepository;

  public TrainerService(TrainerRepository trainerRepository) {
    this.trainerRepository = trainerRepository;
  }

  public List<TrainerVo> findNotGroupedTrainer(Boolean grouped) {
    return trainerRepository.findAllByGroupedOrderByIdAsc(grouped)
            .stream()
            .map(item -> item.toBo().toVo())
            .collect(Collectors.toList());
  }

  public TrainerVo createTrainer(TrainerVo trainerVo) {
    return trainerRepository.save(trainerVo.toBo().toDo()).toBo().toVo();
  }
}
