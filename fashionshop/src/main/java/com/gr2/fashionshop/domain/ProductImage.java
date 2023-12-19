package com.gr2.fashionshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "product_images")
public class ProductImage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String imageId;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private String imageUrl;

}
