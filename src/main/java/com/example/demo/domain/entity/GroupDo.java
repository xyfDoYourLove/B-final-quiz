package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDo {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL,  mappedBy = "group")
  private List<TrainerDo> trainers;

  @OneToMany(cascade = CascadeType.ALL,  mappedBy = "group")
  private List<TraineeDo> trainees;



}
