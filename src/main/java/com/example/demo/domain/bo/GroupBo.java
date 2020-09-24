package com.example.demo.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBo {

  private long id;

  private String name;

  private List<TrainerBo> trainers;

  private List<TraineeBo> trainees;
}
