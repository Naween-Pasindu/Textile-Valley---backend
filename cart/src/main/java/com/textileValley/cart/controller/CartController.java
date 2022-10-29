package com.textileValley.cart.controller;

import com.textileValley.cart.model.Cart;
import com.textileValley.cart.service.IcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private IcartService icartService;

    @GetMapping("/")
//    public  ResponseEntity<?> getCartByBuyerId(@PathVariable Long buyerId){
//        //return new ResponseEntity.ok(icartService.getItemInCart(buyerId));
//    }
    public String test(){
        return "hello world";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        Long buyerId = 1L;
        Cart tempCart=icartService.findCartByBuyerId(buyerId);
        if (tempCart != null){
            Long cartId = icartService.createCart(cart).getCartId();
        }else {
            Long cartId = tempCart.getCartId();
        }
        return new ResponseEntity<>(icartService.createCart(cart), HttpStatus.CREATED);
    }
}
