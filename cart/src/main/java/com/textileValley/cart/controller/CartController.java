package com.textileValley.cart.controller;

import com.textileValley.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @GetMapping("/test")
    public  String getName(){
        return  "hello world";
    }

}
