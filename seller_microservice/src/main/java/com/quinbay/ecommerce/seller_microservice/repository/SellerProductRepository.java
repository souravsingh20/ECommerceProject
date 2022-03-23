package com.quinbay.ecommerce.seller_microservice.repository;

import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProductRepository extends CrudRepository<SellerProductEntity,Long> {

}
