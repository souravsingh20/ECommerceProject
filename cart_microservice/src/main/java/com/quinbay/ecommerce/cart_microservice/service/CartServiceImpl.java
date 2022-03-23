package com.quinbay.ecommerce.cart_microservice.service;

import com.quinbay.ecommerce.cart_microservice.entity.CartEntity;
import com.quinbay.ecommerce.cart_microservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;



//
//    @Override
//   public void addProduct(Long cart_id, Long user_id,Long product_id){
//
//        Iterable<CartEntity> cartEntityList=cartRepository.findAll();
//        for(CartEntity c : cartEntityList){
//            if(c.getUserId()==user_id&&c.getProductId()==product_id){
//                c.setQuantity(c.getQuantity()+1);
//                cartRepository.save(c);
//                break;
//            }
//        }
//
//        CartEntity cartEntity = new CartEntity(cart_id,product_id,user_id,1L);
//
//
//
//    }


    @Override
    public void deleteProduct(Long userId,Long productId , Long sellerId){

        Iterable<CartEntity>cartList= cartRepository.findAll();

        for(CartEntity c:cartList){
            if( (c.getUserId()==userId && c.getProductId()==productId ) && c.getSellerId()==sellerId   )  {
                    cartRepository.delete(c);
                }

            }
        }





    @Override
    public void addProduct(Long cartId,Long userId,Long productId , Long sellerId) {
        Optional<CartEntity> optionalCartEntity = cartRepository.findByUserIdAndProductIdAndSellerId(userId, productId,sellerId);
        if(optionalCartEntity.isPresent()) {
            CartEntity cartEntity = optionalCartEntity.get();
            cartEntity.setQuantity(cartEntity.getQuantity()+1);
            cartRepository.save(cartEntity);

        }
        else {
            CartEntity cartEntity1=new CartEntity(productId,userId,1L,sellerId);
            cartRepository.save(cartEntity1);
        }


    }
}
