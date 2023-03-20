package com.example.emart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  Long price;
  Double discount, rating;
  String name, thumbnail, description, category, brand;
}
