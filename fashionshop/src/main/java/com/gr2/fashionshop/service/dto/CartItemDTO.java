package com.gr2.fashionshop.service.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private String productId;
    private  Integer quantity;
    private ProductDTO product;
    private Double price;
    private Double subPrice;
}
