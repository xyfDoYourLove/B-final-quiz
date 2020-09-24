package com.example.demo.domain.bo;

import com.example.demo.domain.vo.GroupVo;
import com.example.demo.domain.vo.TraineeVo;
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

  public TraineeVo toVo() {

    GroupVo groupVo;

    if (this.group == null) {
      groupVo = null;
    }else {
      groupVo = this.group.toVo();
    }

    return TraineeVo.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .githubAccount(this.githubAccount)
            .office(this.office)
            .zoomId(this.zoomId)
            .group(groupVo)
            .build();
  }
}
