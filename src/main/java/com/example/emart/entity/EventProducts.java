package com.example.emart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class EventProducts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="event_id")
  private Events events;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="product_id")
  private Products products;
}
