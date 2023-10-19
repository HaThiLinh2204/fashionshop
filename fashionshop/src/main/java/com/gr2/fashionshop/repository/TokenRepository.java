package com.gr2.fashionshop.repository;

import com.gr2.fashionshop.domain.AuthenticationToken;
import com.gr2.fashionshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);
}