package com.gr2.fashionshop.domain;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Product.
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "products")
public class Product {

  @Id
  private String product_id;

  @NotNull
  @Size(min = 3, max = 30, message = "Product name size should be between 3-30")
  private String name;

  private String description;

  @NotNull
  @DecimalMin(value = "0.00")
  private Double price;

  @Enumerated(EnumType.STRING)
  private Category category;

}
