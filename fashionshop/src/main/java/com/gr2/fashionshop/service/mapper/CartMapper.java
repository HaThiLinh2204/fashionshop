package com.gr2.fashionshop.service.mapper;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.service.dto.CartDTO;
import com.gr2.fashionshop.service.dto.CartItemDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(target = "id", source = "cart.id")
    @Mapping(target = "cartItems", source = "cartItems")
    CartDTO cartToCartDTO(Cart cart, Double totalPrice, List<CartItemDTO> cartItems);

    @Mapping(target = "subTotal", expression = "java(cartItem.getSubPrice())")
    CartItemDTO cartItemToCartItemDTO(CartItem cartItem);
}
