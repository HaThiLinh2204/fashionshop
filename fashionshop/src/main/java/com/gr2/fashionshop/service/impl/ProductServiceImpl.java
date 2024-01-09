package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.exceptions.CategoryNotFoundException;
import com.gr2.fashionshop.exceptions.ProductNotFoundException;
import com.gr2.fashionshop.repository.ProductImageRepository;
import com.gr2.fashionshop.repository.ProductRepository;
import com.gr2.fashionshop.service.ProductService;
import com.gr2.fashionshop.service.dto.ProductDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;
  private ProductImageRepository productImageRepository;

  @Override
  public Product addProduct(Product product){
    Optional<Product> product1 = productRepository.findById(product.getProduct_id());
    if(!product1.isPresent()) {
      Product product2 = productRepository.save(product);
      return product2;
    }
    else
      throw new ProductNotFoundException("Product already exists");
  };
  @Override
  public Product getProductById(String id) throws ProductNotFoundException {
    Optional<Product> product = productRepository.findById(id);
    if (product.isPresent()){
      return product.get();
    }
    else
      throw new ProductNotFoundException("Product not found with given id");
  };
  @Override
  public String deleteProduct(String id) throws ProductNotFoundException{
    Optional<Product> product = productRepository.findById(id);
    if(product.isPresent()){
      Product product1 = product.get();
      System.out.println(product1);
      productRepository.delete(product1);
      return "Product deleted by id" ;
    }
    else
      throw new ProductNotFoundException("Product not found with given id");
  };
  @Override
  public Product updateProduct(Product product)throws ProductNotFoundException{
    Optional<Product> product1 = productRepository.findById(product.getProduct_id());
    if(product1.isPresent()){
      product1.get();
      Product product2 = productRepository.save(product);
      return product2;
    }
    else
      throw  new ProductNotFoundException("Product not found with given id");


  };
  @Override
  public List<ProductDTO> getProductsOfCategory(Category category){
    List<ProductDTO> list = productRepository.getAllProductsInACategory(category);
    if (list.size() > 0){
      return list;
    }
    else
      throw new CategoryNotFoundException("No products found with category:" + category);
  };

  @Override
  public List<Product> getAllProducts(){
    List<Product> list = productRepository.findAll();
    if(list.size() > 0){
      return list;
    }
    else
      throw new ProductNotFoundException("No products found");
  }
}
