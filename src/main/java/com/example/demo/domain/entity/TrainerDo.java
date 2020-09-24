package com.example.demo.domain.entity;

import com.example.demo.domain.bo.GroupBo;
import com.example.demo.domain.bo.TrainerBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDo {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  private boolean grouped;

  @ManyToOne
  private GroupDo group;

  public TrainerBo toBo() {
    GroupBo groupBo;
    if (this.group == null) {
      groupBo = null;
    }else {
      groupBo = this.group.toBo();
    }
    return TrainerBo.builder()
            .id(this.id)
            .name(this.name)
            .group(groupBo)
            .build();
  }

}
