package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.service.dto.CartDTO;

public interface CartItemService {
    CartItem createItemforCart(CartDTO cartDTO);
}
