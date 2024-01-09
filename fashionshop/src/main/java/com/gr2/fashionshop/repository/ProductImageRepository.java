package com.gr2.fashionshop.repository;

import com.gr2.fashionshop.domain.ProductImage;
import com.gr2.fashionshop.service.dto.ProductImageDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
  @Query("select new com.gr2.fashionshop.service.dto.ProductImageDTO(i.imageId, i.imageUrl) " +
      "from ProductImage i where i.product.product_id = :productId")
  public List<ProductImageDTO> getAllPoductImagesByProductId(@Param("productId") String productId);

}
