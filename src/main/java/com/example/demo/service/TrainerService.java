package com.example.demo.service;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.entity.TrainerDo;
import com.example.demo.domain.vo.TrainerVo;
import com.example.demo.exception.EntityNotExistException;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

  public void deleteTrainerById(Long trainerId) {
    Optional<TrainerDo> trainerDo = trainerRepository.findById(trainerId);
    if (!trainerDo.isPresent()) {
      throw new EntityNotExistException(ExceptionMessageConstant.TRAINER_NOT_EXIST, trainerId.toString());
    }
    trainerRepository.delete(trainerDo.get());
  }
}
