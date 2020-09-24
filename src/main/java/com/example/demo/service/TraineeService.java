package com.example.demo.service;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.entity.TraineeDo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.exception.EntityNotExistException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
            .map(item -> item.toBo().toVo())
            .collect(Collectors.toList());
  }

  public TraineeVo createTrainee(TraineeVo traineeVo) {
    return traineeRepository.save(traineeVo.toBo().toDo()).toBo().toVo();
  }

  public void deleteTraineeById(Long traineeId) {
    Optional<TraineeDo> traineeDo = traineeRepository.findById(traineeId);
    if (!traineeDo.isPresent()) {
      throw new EntityNotExistException(ExceptionMessageConstant.TRAINEE_NOT_EXIST, traineeId.toString());
    }
    traineeRepository.delete(traineeDo.get());
  }
}
