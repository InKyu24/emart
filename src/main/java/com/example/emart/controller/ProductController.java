package com.example.emart.controller;

import com.example.emart.entity.Products;
import com.example.emart.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(tags = {"상품 API"})
public class ProductController {
  private final ProductService productService;

  @GetMapping("/all")
  @ApiOperation(value = "전체 상품 리스트 조회")
  public List<Products> getAllProductsList() {
    return productService.getAllProductsList();
  }

  // 특정 상품 상세보기
  @GetMapping("/{id}")
  @ApiOperation(value = "특정 상품 상세 조회")
  public Products getProductDetail(@PathVariable Long id) {
    return productService.getProductDetail(id);
  }

  // 상품명 검색 결과 리스트 조회
  @GetMapping("/search")
  @ApiOperation(value = "특정 상품 이름으로 검색")
  public List<Products> getProductSearchList(@RequestParam String q) {
    return productService.getProductSearchList(q);
  }

}