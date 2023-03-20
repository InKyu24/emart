package com.example.emart.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
public class Events {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  String name;
}
