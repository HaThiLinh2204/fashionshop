package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.service.dto.CartDTO;
import java.util.Optional;

public interface CartItemService {

  public Optional<CartItem> findCartItemByProductAndSize(Cart cart, Product product, Size size);

  public CartItem createCartItem(Cart cart, Product product, Size size, int quantity);

  public void removeCartItem(Cart cart, String cartItemId);

}
