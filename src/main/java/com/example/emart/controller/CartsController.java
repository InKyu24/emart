package com.example.emart.controller;

import com.example.emart.dto.CartDTO;
import com.example.emart.dto.UserDTO;
import com.example.emart.entity.Carts;
import com.example.emart.entity.Products;
import com.example.emart.entity.Users;
import com.example.emart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartsController {
  private final CartService cartService;

  // 특정 사용자 장바구니에서 전체 상품 리스트 조회
  @GetMapping("/all")
  public List<Products> getAllCartProductList(@RequestParam Long userId) {
    return cartService.getAllCartProductList(userId);
  }

  // 특정 사용자 장바구니에 상품 담기
  @PostMapping("/add")
  public Carts addCartProduct(@RequestBody CartDTO cartDTO) {
    return cartService.addCartProduct(cartDTO);
  }

  // 특정 사용자 장바구니에서 수량 업데이트
  @PatchMapping("/update/{id}")
  public Carts changeCartInfo(@RequestBody CartDTO cartDTO, @PathVariable Long id) {
    return cartService.changeCartQty(cartDTO.getQty(), id);
  }

  // 특정 사용자 장바구니에서 상품 삭제
  @DeleteMapping("/delete/{id}")
  public void deleteCartProduct(@PathVariable Long id) {
    cartService.deleteCartProduct(id);
  }
}
