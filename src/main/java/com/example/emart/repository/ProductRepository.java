package com.example.emart.repository;

import com.example.emart.entity.Products;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class ProductRepository {
  private final EntityManager em;

  public Products findById(Long id) {
    return em.find(Products.class, id);
  }

  public List<Products> getAllProductsList() {
    return em.createQuery("SELECT p FROM Products p", Products.class).getResultList();
  }

  public List<Products> getProductSearchList(String searchWord) {
    return em.createQuery("SELECT p FROM Products p WHERE p.name like :name", Products.class)
        .setParameter("name", "%" + searchWord + "%")
        .getResultList();
  }
}