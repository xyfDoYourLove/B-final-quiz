package com.example.demo.api;

import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/trainees")
public class TraineeController {

  private final TraineeService traineeService;

  public TraineeController(TraineeService traineeService) {
    this.traineeService = traineeService;
  }

  @GetMapping
  public List<TraineeVo> getNotGroupedTrainee(@RequestParam Boolean grouped) {
    return traineeService.findNotGroupedTrainee(grouped);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TraineeVo createTrainee(@RequestBody @Valid TraineeVo traineeVo) {
    return traineeService.createTrainee(traineeVo);
  }

}
