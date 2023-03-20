package com.example.emart.repository;

import com.example.emart.entity.Events;
import com.example.emart.entity.Products;
import lombok.RequiredArgsConstructor;
import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class EventRepository {
  private final EntityManager em;

  public List<Events> getEvents() {
    return em.createQuery("SELECT e FROM Events e", Events.class).getResultList();
  }

  public Events getEvent(Long id) {
    return em.find(Events.class, id);
  }

  public List<Products> getEventProducts(Events event) {
    return em.createQuery("SELECT ep.products FROM EventProducts ep WHERE ep.events=:event", Products.class)
        .setParameter("event", event)
        .getResultList();
  }
}
