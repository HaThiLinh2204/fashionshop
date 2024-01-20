package com.gr2.fashionshop.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cart_items")
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name = "product_id")
  private String productId;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @Column(name = "price")
  private Double price;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "sub_price")
  private Double subPrice;
}
