package com.textileValley.cart.repository;

import com.textileValley.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IcartRepository  extends JpaRepository<Cart, Long> {
    Optional<Cart> findCartByBuyerId(Long buyerId);
}
