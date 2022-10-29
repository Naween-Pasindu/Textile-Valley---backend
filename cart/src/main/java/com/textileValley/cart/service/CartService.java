package com.textileValley.cart.service;

import com.textileValley.cart.model.Buyer;
import com.textileValley.cart.model.Cart;
import com.textileValley.cart.model.Item;
import com.textileValley.cart.repository.IcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class CartService implements IcartService {
    @Autowired
    private IcartRepository icartRepository;

    @Override
    public Buyer findByBuyerId(Long buyerId) {
        return icartRepository.getBuyerByBuyerId(buyerId);
    }

    @Override
    public Cart createCart(Cart cart)
    {
        return icartRepository.save(cart);
    }

    @Override
    public List<Item> getItemInCart(Long buyerId){
        return  icartRepository.getItemByBuyerId(buyerId);
    }

    @Override
    public Cart findCartByBuyerId(Long buyerId){
        return icartRepository.findCartByBuyerId(buyerId).orElse(null);
    }
}
