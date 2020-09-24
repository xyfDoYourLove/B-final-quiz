package com.example.demo.api;

import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.domain.vo.TrainerVo;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/trainers")
public class TrainerController {

  private final TrainerService trainerService;

  public TrainerController(TrainerService trainerService) {
    this.trainerService = trainerService;
  }

  @GetMapping
  public List<TrainerVo> getNotGroupedTrainer(@RequestParam Boolean grouped) {
    return trainerService.findNotGroupedTrainer(grouped);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TrainerVo createTrainee(@RequestBody @Valid TrainerVo trainerVo) {
    return trainerService.createTrainer(trainerVo);
  }

  @DeleteMapping(path = "/{trainer_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTrainerById(@PathVariable("trainer_id") Long trainerId) {
    trainerService.deleteTrainerById(trainerId);
  }
}
