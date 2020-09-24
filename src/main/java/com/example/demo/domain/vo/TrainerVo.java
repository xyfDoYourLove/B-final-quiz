package com.example.demo.domain.vo;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.bo.TrainerBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerVo {

  private long id;

  @NotBlank(message = ExceptionMessageConstant.TRAINER_USERNAME_IS_REQUIRED)
  private String name;

  public TrainerBo toBo() {
    return TrainerBo.builder()
            .name(this.name)
            .group(null)
            .build();
  }

}
