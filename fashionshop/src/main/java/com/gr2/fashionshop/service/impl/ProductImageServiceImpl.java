package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.ProductImage;
import com.gr2.fashionshop.exceptions.ImageNotFoundException;
import com.gr2.fashionshop.exceptions.ProductNotFoundException;
import com.gr2.fashionshop.repository.ProductImageRepository;
import com.gr2.fashionshop.service.ProductImageService;
import com.gr2.fashionshop.service.dto.ProductImageDTO;
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
    Optional<ProductImage> productImage1 = productImageRepository.findById(
        productImage.getImageId());
    if (!productImage1.isPresent()) {
      //productImage1.get();
      ProductImage productImage2 = productImageRepository.save(productImage);
      return productImage2;
    } else {
      throw new ImageNotFoundException("Image already exists");
    }
  }

  @Override
  public List<ProductImageDTO> getAllProductImagesByProductId(String productId) {
    List<ProductImageDTO> list = productImageRepository.getAllPoductImagesByProductId(productId);
    if (list.size() > 0) {
      return list;
    } else {
      return list;
//      throw new ProductNotFoundException("No products found");
    }
  }

  @Override
  public String deleteProductImage(String id) {
    Optional<ProductImage> productImage = productImageRepository.findById(id);
    if (productImage.isPresent()) {
      ProductImage productImage1 = productImage.get();
      productImageRepository.delete(productImage1);

      return "Deleted successfully";
    } else {
      return "Delete fails";
    }
  }

  @Override
  public void deleteProductImagesByProductId(String productId) {
    List<ProductImage> images = productImageRepository.findByProductId(productId);
    productImageRepository.deleteAll(images);
  }
}
