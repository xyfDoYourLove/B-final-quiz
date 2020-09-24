package com.example.demo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupVo {

  private long id;

  private String name;

  private List<TrainerVO> trainers;

  private List<TraineeVo> trainees;

}
