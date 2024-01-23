package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.exceptions.ProductNotFoundException;
import com.gr2.fashionshop.exceptions.SizeNotFoundException;
import com.gr2.fashionshop.repository.SizeRepository;
import com.gr2.fashionshop.service.SizeService;
import com.gr2.fashionshop.service.dto.SizeDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService {

  @Autowired
  private SizeRepository sizeRepository;

  @Override
  public Size addSize(Size size) {
    Optional<Size> size1 = sizeRepository.findById(size.getSizeId());
    if (!size1.isPresent()) {
      Size size2 = sizeRepository.save(size);
      return size2;
    } else {
      throw new SizeNotFoundException("Size product already exists");
    }
  }

  @Override
  public String deleteSize(String id) {
    Optional<Size> size = sizeRepository.findById(id);
    if (size.isPresent()) {
      Size size1 = size.get();
      sizeRepository.delete(size1);
      return "Deleted successfully";
    } else {
      return "Delete fails";
    }
  }

  @Override
  public void deleteSizesByProductId(String productId) {
    List<Size> sizes = sizeRepository.findByProductId(productId);
    sizeRepository.deleteAll(sizes);
  }

  @Override
  public List<SizeDTO> getAllSizeByProductId(String productId) {
    List<SizeDTO> list = sizeRepository.getAllSizesByProductId(productId);
    if (list.size() > 0) {
      return list;
    } else {
      throw new ProductNotFoundException("No products found");
    }
  }

  @Override
  public Size getSizeById(String id) {
    Optional<Size> size = sizeRepository.findById(id);
    if (size.isPresent()) {
      Size size1 = size.get();
      return size1;
    } else {
      throw new SizeNotFoundException("Size product already exists");
    }
  }
}
