package com.textileValley.cart.repository;

import com.textileValley.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository  extends JpaRepository<Cart, Long> {

}
