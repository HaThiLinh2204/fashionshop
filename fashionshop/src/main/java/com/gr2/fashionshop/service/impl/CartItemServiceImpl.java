package com.gr2.fashionshop.service.impl;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.CartItem;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.exceptions.ProductNotFoundException;
import com.gr2.fashionshop.exceptions.SizeNotFoundException;
import com.gr2.fashionshop.repository.CartItemRepository;
import com.gr2.fashionshop.repository.ProductRepository;
import com.gr2.fashionshop.repository.SizeRepository;
import com.gr2.fashionshop.service.CartItemService;
import com.gr2.fashionshop.service.dto.CartDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

  @Autowired
  CartItemRepository cartItemRepository;
  @Autowired
  ProductRepository productRepository;

  @Autowired
  SizeRepository sizeRepository;

  @Override
  public Optional<CartItem> findCartItemByProductAndSize(Cart cart, Product product, Size size) {
    return cart.getCartItems().stream()
        .filter(item -> item.getProduct().equals(product) && item.getSize().equals(size))
        .findFirst();
  }

  @Override
  public CartItem createCartItem(Cart cart, Product product, Size size, int quantity) {
    Optional<CartItem> existingCartItem = findCartItemByProductAndSize(cart, product, size);

    if (existingCartItem.isPresent()) {
      existingCartItem.get().setQuantity(existingCartItem.get().getQuantity() + quantity);
      return cartItemRepository.save(existingCartItem.get());
    } else {
      CartItem cartItem = new CartItem();
      cartItem.setProduct(product);
      cartItem.setSize(size);
      cartItem.setQuantity(quantity);
      cartItem.setCart(cart);
      return cartItemRepository.save(cartItem);
    }
  }

  @Override
  public void removeCartItem(Cart cart, String cartItemId) {
    List<CartItem> cartItems = cart.getCartItems();
    cartItems.removeIf(cartItem -> cartItem.getId().equals(cartItemId));
    cartItemRepository.deleteByCartAndId(cart, cartItemId);
  }

}
