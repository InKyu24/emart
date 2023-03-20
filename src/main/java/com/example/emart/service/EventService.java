package com.example.emart.service;

import com.example.emart.entity.Events;
import com.example.emart.entity.Products;
import com.example.emart.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {
  private final EventRepository eventRepository;

  public List<Events> getEvents() {
    return eventRepository.getEvents();
  }

  public List<Products> getEventProducts(Long id) {
    Events event= eventRepository.getEvent(id);
    return eventRepository.getEventProducts(event);
  }
}
