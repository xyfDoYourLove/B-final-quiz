package com.example.demo.domain.entity;

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

  @ManyToOne
  private GroupDo group;

}
