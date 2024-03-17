package com.gr2.fashionshop.service.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeDTO implements Serializable {

  private String sizeId;
  private String sizeName;
  private int quantity;
}
