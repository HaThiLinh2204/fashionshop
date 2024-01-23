package com.gr2.fashionshop.controller;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.domain.Size;
import com.gr2.fashionshop.service.CartService;
import com.gr2.fashionshop.service.ProductService;
import com.gr2.fashionshop.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartResource {

  @Autowired
  private final CartService cartService;

  @Autowired
  private final ProductService productService;

  @Autowired
  private final SizeService sizeService;

  @GetMapping
  public ResponseEntity<Cart> getCart() {

    return ResponseEntity.ok(cartService.getCart());
  }

  @PostMapping("/add")
  public ResponseEntity<String> addToCart(@RequestParam String productId,
      @RequestParam String sizeId,
      @RequestParam int quantity) {
    Product product = productService.getProductById(productId);
    Size size = sizeService.getSizeById(sizeId);

    if (product != null && size != null) {
      cartService.addToCart(product, size, quantity);
      return ResponseEntity.ok("Product added to cart successfully.");
    } else {
      return ResponseEntity.badRequest().body("Invalid productId or sizeId.");
    }
  }

  @PostMapping("/remove")
  public ResponseEntity<String> removeCartItem(@RequestParam String cartItemId) {
    cartService.removeCartItem(cartItemId);
    return ResponseEntity.ok("CartItem removed from cart successfully.");
  }

  @PostMapping("/clear")
  public ResponseEntity<String> clearCart() {
    cartService.clearCart();
    return ResponseEntity.ok("Cart cleared successfully.");
  }
}
