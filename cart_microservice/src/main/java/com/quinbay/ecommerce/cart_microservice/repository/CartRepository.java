package com.quinbay.ecommerce.cart_microservice.repository;

import com.quinbay.ecommerce.cart_microservice.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CartRepository extends CrudRepository<CartEntity,Long> {

    Optional<CartEntity> findByUserIdAndProductIdAndSellerId(Long userId, Long productId,Long sellerId);

}
