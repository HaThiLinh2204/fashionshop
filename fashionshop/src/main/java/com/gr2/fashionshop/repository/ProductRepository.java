package com.gr2.fashionshop.repository;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.service.dto.ProductDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Product entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  @Query(
      "select new com.gr2.fashionshop.service.dto.ProductDTO(p.product_id,p.name,p.description,p.price) "
          + "from Product p where p.category=:catenum")
  public List<ProductDTO> getAllProductsInACategory(@Param("catenum") Category catenum);
}
