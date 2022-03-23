package com.quinbay.ecommerce.cart_microservice.controller;

import com.quinbay.ecommerce.cart_microservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CartController {
    @Autowired
    CartService cartService;

    @DeleteMapping(value = "/productDelete" , consumes = "application/json")
    public void delete(@RequestParam Long userId,@RequestParam Long productId,@RequestParam Long sellerId){
        cartService.deleteProduct(userId,productId,sellerId);
    }


    @PostMapping(value = "/addProduct", consumes ="application/json")
    public void add(@RequestParam Long cartId ,@RequestParam Long userId,@RequestParam Long productId,@RequestParam Long sellerId){
        cartService.addProduct(cartId,userId,productId,sellerId);
    }



}




