package com.gr2.fashionshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sizes")
public class Size {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String sizeId;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @NotNull
  @javax.validation.constraints.Size(min = 3, max = 30, message = "Size name size should be between 3-30")
  private String sizeName;

  @NotNull
  @Min(value = 0)
  private int quantity;
}
