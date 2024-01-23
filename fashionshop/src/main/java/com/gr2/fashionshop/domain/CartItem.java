package com.gr2.fashionshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Data
@Table(name = "cart_items")
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @OneToOne
  private Product product;

  @OneToOne
  private Size size;

  private Integer quantity;

  private double subTotal;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;

}
