package com.textileValley.cart.service;

import com.textileValley.cart.model.Cart;
import com.textileValley.cart.repository.IcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IcartService {
    Cart addCart(Cart cart);
}
