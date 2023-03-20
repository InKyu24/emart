package com.example.emart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Carts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long qty;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="user_id")
  Users users;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="product_id")
  Products products;
}
