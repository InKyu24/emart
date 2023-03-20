package com.example.emart.repository;

import com.example.emart.dto.CartDTO;
import com.example.emart.entity.Carts;
import com.example.emart.entity.Users;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepository {
  private final EntityManager em;

  public void save(Users user) {
    em.persist(user);
  }

  public Optional<Users> getUserInfoById(Long id) {
    return Optional.ofNullable(em.find(Users.class, id));
  }

  public Optional<Users> getUserInfoByEmail(String email) {
    return em.createQuery("SELECT u FROM Users u WHERE u.email=:email", Users.class)
        .setParameter("email", email)
        .getResultList()
        .stream()
        .findAny();
  }

  public Optional<Carts> getSameProduct(CartDTO cartDTO) {
    return em.createQuery("SELECT c FROM Carts c WHERE c.products.id=:productId and c.users.id=:userId", Carts.class)
        .setParameter("productId", cartDTO.getProductId())
        .setParameter("userId", cartDTO.getUserId())
        .getResultStream().findFirst();
  }
}
