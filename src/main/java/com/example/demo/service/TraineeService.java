package com.example.demo.service;

import com.example.demo.domain.entity.TraineeDo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraineeService {

  private final TraineeRepository traineeRepository;

  public TraineeService(TraineeRepository traineeRepository) {
    this.traineeRepository = traineeRepository;
  }

  public List<TraineeVo> findNotGroupedTrainee(Boolean grouped) {
    return traineeRepository.findAllByGroupedOrderByIdAsc(grouped)
            .stream()
            .map(item -> item.toBo())
            .map(item -> item.toVo())
            .collect(Collectors.toList());
  }
}
