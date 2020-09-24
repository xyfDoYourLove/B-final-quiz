package com.example.demo.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeBo {

  private long id;

  private String name;

  private String office;

  private String email;

  private String zoomId;

  private String githubAccount;

  private GroupBo group;
}
