package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.exceptions.CartItemNotFound;
import com.gr2.fashionshop.service.dto.CartDTO;
import com.gr2.fashionshop.service.dto.CartItemDTO;

import java.util.List;

public interface CartService {
    CartDTO getCartByUserId(Integer userId);
    int getNumberOfItemsInCart(Integer userId);

    CartDTO addItemToCart(Integer userId, Integer productId, int quantity);
    CartDTO removeItemFromCart(Integer userId, Integer productId);
    Cart getCartEntityByUserId(Integer userId);
    void clearCart(Integer userId);
}
