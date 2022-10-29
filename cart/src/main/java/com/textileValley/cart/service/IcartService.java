package com.textileValley.cart.service;

import com.textileValley.cart.model.Buyer;
import com.textileValley.cart.model.Cart;
import com.textileValley.cart.model.Item;

import java.util.List;

public interface IcartService {

    Buyer findByBuyerId(Long buyerId);
    
    Cart createCart(Cart cart);
    List<Item> getItemInCart(Long buyerId);

    Cart findCartByBuyerId(Long buyerId);
}
