package com.example.demo.domain.vo;

import com.example.demo.common.constant.ExceptionMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupVo {

  private long id;

  @NotBlank(message = ExceptionMessageConstant.GROUP_NAME_IS_REQUIRED)
  private String name;

  private List<TrainerVo> trainers;

  private List<TraineeVo> trainees;

}
