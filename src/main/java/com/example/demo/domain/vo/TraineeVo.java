package com.example.demo.domain.vo;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.bo.TraineeBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraineeVo {

  private long id;

  @NotBlank(message = ExceptionMessageConstant.TRAINEE_NAME_IS_REQUIRED)
  private String name;

  @NotBlank(message = ExceptionMessageConstant.OFFICE_IS_REQUIRED)
  private String office;

  @NotBlank(message = ExceptionMessageConstant.EMAIL_IS_REQUIRED)
  @Email
  private String email;

  @NotBlank(message = ExceptionMessageConstant.ZOOM_ID_IS_REQUIRED)
  private String zoomId;

  @NotBlank(message = ExceptionMessageConstant.GITHUB_IS_REQUIRED)
  private String github;

  public TraineeBo toBo() {
    return TraineeBo.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .github(this.github)
            .office(this.office)
            .zoomId(this.zoomId)
            .group(null)
            .build();
  }

}
