package com.example.emart.controller;

import com.example.emart.entity.Events;
import com.example.emart.entity.Products;
import com.example.emart.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController {

  private final EventService eventService;

  // 전체 이벤트 리스트 조회
  @GetMapping("/all")
  public List<Events> getEvents() {
    return eventService.getEvents();
  }

  // 특정 이벤트 진행 상품 리스트 조회
  @GetMapping("/{id}")
  public List<Products> getEventProducts(@PathVariable Long id) {
    return eventService.getEventProducts(id);
  }
}
