package com.example.emart.controller.restController;

import com.example.emart.dto.CartDTO;
import com.example.emart.entity.Carts;
import com.example.emart.entity.Products;
import com.example.emart.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
@Api(tags = {"장바구니 API"})
public class CartsController {
  private final CartService cartService;

  @GetMapping("/all")
  @ApiOperation(value = "장바구니 상품 리스트 조회", notes = "userId를 이용해 장바구니 내 상품 리스트 조회")
  public List<Products> getAllCartProductList(@RequestParam Long userId) {
    return cartService.getAllCartProductList(userId);
  }

  @PostMapping("/add")
  @ApiOperation(value = "장바구니 상품 추가", notes = "장바구니 내 상품 추가(동일 상품 존재 시, 자동으로 수량 증가)")
  public Carts addCartProduct(@RequestBody CartDTO cartDTO) {
    return cartService.addCartProduct(cartDTO);
  }

  // 특정 사용자 장바구니에서 수량 업데이트
  @PatchMapping("/update/{id}")
  @ApiOperation(value = "장바구니 수량 변경", notes = "장바구니 상품 수량 증가 또는 감소")
  public Carts changeCartInfo(@RequestBody CartDTO cartDTO, @PathVariable Long id) {
    return cartService.changeCartQty(cartDTO.getQty(), id);
  }

  // 특정 사용자 장바구니에서 상품 삭제
  @DeleteMapping("/delete/{id}")
  @ApiOperation(value = "장바구니 내 특정 상품 삭제")
  public void deleteCartProduct(@PathVariable Long id) {
    cartService.deleteCartProduct(id);
  }
}
