package com.quinbay.ecommerce.cart_microservice.service;

public interface CartService {

    void addProduct(Long cartId,Long userId,Long productId,Long sellerId);

    void deleteProduct(Long userId,Long productId,Long sellerId);


}
