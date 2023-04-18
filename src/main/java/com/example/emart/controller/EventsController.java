package com.example.emart.controller.restController;

import com.example.emart.entity.Events;
import com.example.emart.entity.Products;
import com.example.emart.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
@Api(tags = {"이벤트 API"})
public class EventsController {

  private final EventService eventService;

  // 전체 이벤트 리스트 조회
  @GetMapping("/all")
  @ApiOperation(value = "전체 이벤트 리스트 조회")
  public List<Events> getEvents() {
    return eventService.getEvents();
  }

  // 특정 이벤트 진행 상품 리스트 조회
  @GetMapping("/{id}")
  @ApiOperation(value = "특정 이벤트 내 상품 리스트 조회")
  public List<Products> getEventProducts(@PathVariable Long id) {
    return eventService.getEventProducts(id);
  }
}
