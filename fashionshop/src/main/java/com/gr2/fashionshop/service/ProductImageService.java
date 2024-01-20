package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.ProductImage;
import com.gr2.fashionshop.service.dto.ProductImageDTO;
import java.util.List;

public interface ProductImageService {

  public ProductImage addProductImage(ProductImage productImage);

  public List<ProductImageDTO> getAllProductImagesByProductId(String productId);

  public String deleteProductImage(String id);

  public void deleteProductImagesByProductId(String productId);
}
