package com.textileValley.cart.service;

import com.textileValley.cart.model.Cart;
import com.textileValley.cart.repository.IcartRepository;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;

public  class CartService implements IcartService {
    @Target(IcartRepository.class)
    IcartRepository icartRepository;
    @Override
    public Cart addCart(Cart cart)
    {
        return icartRepository.save(cart);
    }

}
