package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.ProductImage;
import java.util.List;

public interface ProductImageService {

  public ProductImage addProductImage(ProductImage productImage);

  public List<ProductImage> getAllProductImagesByProductId(String productId);

  public String deleteProductImage(String id);

}
