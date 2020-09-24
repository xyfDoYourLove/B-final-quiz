package com.example.demo.domain.bo;

import com.example.demo.domain.entity.TrainerDo;
import com.example.demo.domain.vo.TrainerVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerBo {

  private long id;

  private String name;

  private GroupBo group;

  public TrainerVo toVo() {
    return TrainerVo.builder()
            .id(this.id)
            .name(this.name)
            .build();
  }

  public TrainerDo toDo() {
    return TrainerDo.builder()
            .name(this.name)
            .group(null)
            .grouped(false)
            .build();
  }
}
