package com.textileValley.cart.controller;

import com.textileValley.cart.model.Cart;
import com.textileValley.cart.service.IcartService;
import org.hibernate.annotations.Target;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Target(IcartService.class)
    private IcartService icartService;

    @GetMapping("/test")
    public  String getName(){
        return  "hello world";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        return new ResponseEntity<>(icartService.addCart(cart), HttpStatus.CREATED);
    }
}
