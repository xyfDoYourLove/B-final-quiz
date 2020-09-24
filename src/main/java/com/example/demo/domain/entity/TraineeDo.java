package com.example.demo.domain.entity;

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

  private String githubAccount;

  @ManyToOne
  private GroupDo group;

}
