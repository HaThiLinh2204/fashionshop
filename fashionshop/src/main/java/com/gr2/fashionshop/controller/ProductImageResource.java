package com.gr2.fashionshop.controller;

import com.gr2.fashionshop.domain.ProductImage;
import com.gr2.fashionshop.service.ProductImageService;
import com.gr2.fashionshop.service.dto.ProductImageDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductImageResource {

  @Autowired
  private final ProductImageService productImageService;

  @PostMapping("/product/image")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<ProductImage> addProductImage(@RequestBody ProductImage productImage) {
    ProductImage productImage1 = productImageService.addProductImage(productImage);
    return new ResponseEntity<ProductImage>(productImage1, HttpStatus.CREATED);
  }

  @GetMapping("product/image/{productId}")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<List<ProductImageDTO>> getAllProductImagesByProductId(
      @PathVariable("productId") String productId) {
    List<ProductImageDTO> list = productImageService.getAllProductImagesByProductId(productId);
    return new ResponseEntity<List<ProductImageDTO>>(list, HttpStatus.OK);
  }

  @DeleteMapping("/product/image/{imageId}")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<String> deleteProductImage(@PathVariable("imageId") String imageId) {
    String res = productImageService.deleteProductImage(imageId);
    return new ResponseEntity<String>(res, HttpStatus.OK);
  }
}
