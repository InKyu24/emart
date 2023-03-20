package com.example.emart.service;

import com.example.emart.entity.Products;
import com.example.emart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Products> getAllProductsList() {
    return productRepository.getAllProductsList();
  }

  public Products getProductDetail(Long id) {
    return productRepository.findById(id);
  }

  public List<Products> getProductSearchList(String searchWord) {
    return productRepository.getProductSearchList(searchWord);
  }
}
