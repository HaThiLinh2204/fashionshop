package com.gr2.fashionshop.repository;

import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.service.dto.SizeDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface SizeRepository extends JpaRepository<Size, String> {

  @Query("select new com.gr2.fashionshop.service.dto.SizeDTO(s.sizeName, s.quantity) " +
      "from Size s where s.productId = :productId")
  public List<SizeDTO> getAllSizesByProductId(@Param("productId") String productId);

  List<Size> findByProductId(String productId);

  void deleteByProductId(String productId);

  //  @Query("select s from Size s where s.productId = :productId")
  // public List<Size> getAllByProductId(@Param("productId") String productId);
}
