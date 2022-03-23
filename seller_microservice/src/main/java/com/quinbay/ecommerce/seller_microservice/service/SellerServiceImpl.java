package com.quinbay.ecommerce.seller_microservice.service;

import com.quinbay.ecommerce.seller_microservice.dto.Seller;
import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import com.quinbay.ecommerce.seller_microservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void addSeller(Seller seller){
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setId(seller.getId());
        sellerEntity.setName(seller.getName());
        sellerEntity.setEmail(seller.getEmail());
        sellerEntity.setRatings(seller.getRatings());
        sellerRepository.save(sellerEntity);
    }
}
