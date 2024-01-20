package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.service.dto.SizeDTO;
import java.util.List;

public interface SizeService {

  public Size addSize(Size size);

  public String deleteSize(String id);

  public void deleteSizesByProductId(String productId);

  public List<SizeDTO> getAllSizeByProductId(String productId);

}