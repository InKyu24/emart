package com.example.emart.service;

import com.example.emart.dto.CartDTO;
import com.example.emart.entity.Carts;
import com.example.emart.entity.Products;
import com.example.emart.repository.CartRepository;
import com.example.emart.repository.ProductRepository;
import com.example.emart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {
  private final CartRepository cartRepository;
  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  @Transactional
  public Carts addCartProduct(CartDTO cartDTO) {
    Optional<Carts> sameProduct = userRepository.getSameProduct(cartDTO);
    Carts cart;
    if (sameProduct.isEmpty()) {
      cart = new Carts();
      cart.setUsers(userRepository.getUserInfoById(cartDTO.getUserId()).get());
      cart.setProducts(productRepository.findById(cartDTO.getProductId()));
      cart.setQty(cartDTO.getQty());
    } else {
      cart = sameProduct.get();
      cart.setQty(cart.getQty() + 1L);
    }
    return cartRepository.save(cart);
  }

  public List<Products> getAllCartProductList(Long userId) {
    return cartRepository.getAllCartProductList(userId);
  }

  @Transactional
  public Carts changeCartQty(Long qty, Long id) {
    Carts cart = cartRepository.getCartInfoById(id);
    if (cart.getQty() + qty <= 0) {
      cart.setQty(1L);
    } else {
      cart.setQty(cart.getQty() + qty);
    }
    return cart;
  }

  @Transactional
  public void deleteCartProduct(Long id) {
    Carts cart = cartRepository.getCartInfoById(id);
    cartRepository.deleteCartProduct(cart);
  }
}
