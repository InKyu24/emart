package com.example.emart.repository;

import com.example.emart.entity.Carts;
import com.example.emart.entity.Products;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class CartRepository {
  private final EntityManager em;

  public Carts save(Carts cart) {
    em.persist(cart);
    return cart;
  }

  public List<Products> getAllCartProductList(Long userId) {
    return em.createQuery("select c.products from Carts c where c.users.id=:userId", Products.class)
        .setParameter("userId", userId)
        .getResultList();
  }

  public Carts getCartInfoById(Long id) {
    return em.find(Carts.class, id);
  }

  public void deleteCartProduct(Carts cart) {
    em.remove(cart);
  }
}
