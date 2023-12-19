package com.gr2.fashionshop.service.dto;

import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class CartDTO {
   private String id;
   private  String userId;
   private Double totalPrice;
   private  List<CartItemDTO> cartItems;
}
