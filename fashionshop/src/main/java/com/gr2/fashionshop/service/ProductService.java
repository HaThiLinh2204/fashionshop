package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.service.dto.ProductDTO;

import java.util.List;

/**
 * Service Interface for managing {@link com.gr2.fashionshop.domain.Product}.
 */

public interface ProductService {

  public Product addProduct(Product product);

  public Product getProductById(String id);

  public String deleteProduct(String id);

  public Product updateProduct(Product product);

  public List<ProductDTO> getProductsOfCategory(Category category);

  public List<Product> getAllProducts();

  public int getTotalQuantityOfProduct(String productId);
}
