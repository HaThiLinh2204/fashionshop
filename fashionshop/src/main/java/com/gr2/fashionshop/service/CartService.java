package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.domain.Size;

public interface CartService {

  Cart getCart();

  void addToCart(Product product, Size size, int quantity);

  void removeCartItem(String cartItemId);

  void clearCart();
}
