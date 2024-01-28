package com.gr2.fashionshop.controller;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.service.ProductService;
import com.gr2.fashionshop.service.dto.ProductDTO;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link com.gr2.fashionshop.domain.Product}.
 */
@RequiredArgsConstructor
@RestController
public class ProductResource {

  @Autowired
  private final ProductService productService;

  @PostMapping("/products")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product product1 = productService.addProduct(product);
    return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
  }

  @GetMapping("/product/{id}")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<Product> getProductFromCatalogById(@PathVariable("id") String id) {
    Product prod = productService.getProductById(id);
    return new ResponseEntity<Product>(prod, HttpStatus.FOUND);
  }

  @DeleteMapping("/product/{id}")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<String> deleteProductFromCatalogById(@PathVariable("id") String id) {
    String res = productService.deleteProduct(id);
    return new ResponseEntity<String>(res, HttpStatus.OK);
  }
//  @DeleteMapping("/{productId}")
//  public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
//    productService.deleteProductAndRelatedData(productId);
//    return new ResponseEntity<>("Product and related data deleted successfully", HttpStatus.OK);
//  }

  @PutMapping("products")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<Product> updateProductInCatalog(@Valid @RequestBody Product product) {
    Product product1 = productService.updateProduct(product);
    return new ResponseEntity<Product>(product1, HttpStatus.OK);
  }

  @GetMapping("products/{category}")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<List<ProductDTO>> getAllProductsInCategory(
      @PathVariable("category") String category) {
    Category category1 = Category.valueOf(category.toUpperCase());
    List<ProductDTO> list = productService.getProductsOfCategory(category1);
    return new ResponseEntity<List<ProductDTO>>(list, HttpStatus.OK);
  }

  @GetMapping("products")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> list = productService.getAllProducts();
    return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
  }

}
