package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.repository.CartRepository;
import com.gr2.fashionshop.service.CartItemService;
import com.gr2.fashionshop.service.CartService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private CartItemService cartItemService;

  @Override
  public Cart getCart() {
    // Lấy giỏ hàng duy nhất hoặc tạo mới nếu chưa tồn tại
    return cartRepository.findById(String.valueOf(1L)).orElseGet(() -> {
      Cart newCart = new Cart();
      cartRepository.save(newCart);
      return newCart;
    });
  }

  @Override
  public void addToCart(Product product, Size size, int quantity) {
    Cart cart = getCart();
    CartItem cartItem = cartItemService.createCartItem(cart, product, size, quantity);
    cart.getCartItems().add(cartItem);
    cartRepository.save(cart);
  }

  @Override
  public void removeCartItem(String cartItemId) {
    Cart cart = getCart();
    cartItemService.removeCartItem(cart, cartItemId);
    cartRepository.save(cart);
  }

  @Override
  public void clearCart() {
    Cart cart = getCart();

    // Tạo một bản sao của danh sách để tránh ConcurrentModificationException
    List<CartItem> cartItemsCopy = new ArrayList<>(cart.getCartItems());

    // Xóa các CartItem từ bản sao
    cartItemsCopy.forEach(cartItem -> cartItemService.removeCartItem(cart, cartItem.getId()));

    // Xóa tất cả các CartItem từ danh sách gốc
    cart.getCartItems().clear();

    // Lưu giỏ hàng
    cartRepository.save(cart);
  }
}
