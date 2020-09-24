package com.example.demo.domain.bo;

import com.example.demo.domain.vo.GroupVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBo {

  private long id;

  private String name;

  private List<TrainerBo> trainers;

  private List<TraineeBo> trainees;

  public GroupVo toVo () {
    return GroupVo.builder()
            .id(this.id)
            .name(this.name)
            .trainees(trainees.stream().map(it -> it.toVo()).collect(Collectors.toList()))
            .trainers(trainers.stream().map(it -> it.toVo()).collect(Collectors.toList()))
            .build();
  }
}
