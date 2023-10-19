package com.gr2.fashionshop.repository;

import com.gr2.fashionshop.domain.Cart;
import com.gr2.fashionshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
