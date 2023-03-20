package com.example.emart.dto;

import lombok.Data;

@Data
public class CartDTO {
  Long productId;
  Long userId;
  Long qty;
}