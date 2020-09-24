package com.example.demo.domain.entity;

import com.example.demo.domain.bo.GroupBo;
import com.example.demo.domain.bo.TraineeBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trainee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDo {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  private String office;

  private String email;

  private String zoomId;

  private String github;

  private boolean grouped;

  @ManyToOne
  private GroupDo group;

  public TraineeBo toBo() {
    GroupBo groupBo;
    if (this.group == null) {
      groupBo = null;
    }else {
      groupBo = this.group.toBo();
    }

    return TraineeBo.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .github(this.github)
            .office(this.office)
            .zoomId(this.zoomId)
            .group(groupBo)
            .build();
  }

}
