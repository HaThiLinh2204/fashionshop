package com.gr2.fashionshop.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartResource {
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private CartDao cartDao;
//
//    @Autowired
//    private CustomerDao customerDao;
//
//
//    @PostMapping(value = "/cart/add")
//    public ResponseEntity<Cart> addProductToCartHander(@RequestBody CartDTO cartDTO ,@RequestHeader("token")String token){
//
//        Cart cart = cartService.addProductToCart(cartDTO, token);
//        return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
//    }
//
//    //
//    @GetMapping(value = "/cart")
//    public ResponseEntity<Cart> getCartProductHandler(@RequestHeader("token")String token){
//        return new ResponseEntity<>(cartService.getCartProduct(token), HttpStatus.ACCEPTED);
//    }
//
//
//    @DeleteMapping(value = "/cart")
//    public ResponseEntity<Cart> removeProductFromCartHander(@RequestBody CartDTO cartDTO ,@RequestHeader("token")String token){
//
//        Cart cart = cartService.removeProductFromCart(cartDTO, token);
//        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
//    }
//
//
//    @DeleteMapping(value = "/cart/clear")
//    public ResponseEntity<Cart> clearCartHandler(@RequestHeader("token") String token){
//        return new ResponseEntity<>(cartService.clearCart(token), HttpStatus.ACCEPTED);
//    }
}
