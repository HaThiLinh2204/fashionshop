package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.ProductImage;
import com.gr2.fashionshop.repository.ProductImageRepository;
import com.gr2.fashionshop.service.ProductImageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

  @Autowired
  private ProductImageRepository productImageRepository;

  @Override
  public ProductImage addProductImage(ProductImage productImage) {
//    Optional<ProductImage> productImage1 = productImageRepository
    return null;
  }

  @Override
  public List<ProductImage> getAllProductImagesByProductId(String productId) {
    return null;
  }

  @Override
  public String deleteProductImage(String id) {
    return null;
  }
}
