package com.example.demo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraineeVo {

  private long id;

  private String name;

  private String office;

  private String email;

  private String zoomId;

  private String githubAccount;

  private GroupVo group;

}
