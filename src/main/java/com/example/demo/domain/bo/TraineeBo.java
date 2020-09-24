package com.example.demo.domain.bo;

import com.example.demo.domain.entity.TraineeDo;
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

  private String github;

  private GroupBo group;

  public TraineeVo toVo() {
    return TraineeVo.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .github(this.github)
            .office(this.office)
            .zoomId(this.zoomId)
            .build();
  }

  public TraineeDo toDo() {
    return TraineeDo.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .github(this.github)
            .office(this.office)
            .zoomId(this.zoomId)
            .group(null)
            .grouped(false)
            .build();
  }
}
