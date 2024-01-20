package com.gr2.fashionshop.controller;

import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.service.SizeService;
import com.gr2.fashionshop.service.dto.SizeDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SizeResource {

  @Autowired
  private final SizeService sizeService;

  @PostMapping("/product/size")
  public ResponseEntity<Size> addSize(@RequestBody Size size) {
    Size size1 = sizeService.addSize(size);
    return new ResponseEntity<Size>(size1, HttpStatus.CREATED);
  }

  @GetMapping("product/size/{productId}")
  public ResponseEntity<List<SizeDTO>> getAllSizeByProductId(
      @PathVariable("productId") String productId) {
    List<SizeDTO> list = sizeService.getAllSizeByProductId(productId);
    return new ResponseEntity<List<SizeDTO>>(list, HttpStatus.OK);
  }

  @DeleteMapping("/product/size/{sizeId}")
  public ResponseEntity<String> deleteSize(@PathVariable("sizeId") String sizeId) {
    String res = sizeService.deleteSize(sizeId);
    return new ResponseEntity<String>(res, HttpStatus.OK);
  }

}
