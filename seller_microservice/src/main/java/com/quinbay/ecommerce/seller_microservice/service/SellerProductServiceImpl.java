package com.quinbay.ecommerce.seller_microservice.service;

import com.quinbay.ecommerce.seller_microservice.dto.SellerProduct;
import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;
import com.quinbay.ecommerce.seller_microservice.repository.SellerProductRepository;
import com.quinbay.ecommerce.seller_microservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerProductServiceImpl implements SellerProductService{

    @Autowired
    SellerProductRepository sellerProductRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void addProductBySeller(SellerProduct sellerProduct){
        SellerProductEntity sellerProductEntity = new SellerProductEntity();

        Optional<SellerEntity> byId=sellerRepository.findById(sellerProduct.getSellerId());
        if(byId.isPresent()){
            sellerProductEntity.setSellerEntity(byId.get());
            sellerProductEntity.setStock(sellerProduct.getStock());
            sellerProductEntity.setPrice(sellerProduct.getPrice());
            sellerProductEntity.setId(sellerProduct.getId());
            sellerProductEntity.setSold(sellerProduct.getSold());
            sellerProductEntity.setProductId(sellerProduct.getProductId());
            sellerProductRepository.save(sellerProductEntity);
        }
    }

    @Override
    public List<SellerProduct> getAllSellerProduct() {
        Iterable<SellerProductEntity> sellerProductEntities = sellerProductRepository.findAll();
        List<SellerProduct> list = new ArrayList<>();
        for (SellerProductEntity prod : sellerProductEntities) {
            list.add(new SellerProduct(prod.getId(),
                    prod.getSellerId(),
                    prod.getProductId(),
                    prod.getPrice(),
                    prod.getStock(),
                    prod.getSold()));
        }
        return list;
    }

    @Override
    public SellerProduct updateProductBySeller(SellerProduct sellerProduct){
        Iterable<SellerProductEntity> sellerProductEntityIterable = sellerProductRepository.findAll();
        for(SellerProductEntity sellerProductEntity :sellerProductEntityIterable){
            if(sellerProductEntity.getId() == sellerProduct.getId()){
                sellerProductEntity.setStock(sellerProduct.getStock());
                sellerProductRepository.save(sellerProductEntity);
            }
        }
        return sellerProduct;
    }

    @Override
    public void deleteProductBySeller(Long id){
        for(SellerProductEntity sellerProductEntity : sellerProductRepository.findAll()){
            if(sellerProductEntity.getId()==id){
                sellerProductRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public SellerProduct getSellerProductById(Long id){
        Optional<SellerProductEntity> sellerProductEntity = sellerProductRepository.findById(id);
        if(sellerProductEntity.isPresent()) {
            return new SellerProduct(sellerProductEntity.get().getId(), sellerProductEntity.get().getSellerId(),sellerProductEntity.get().getProductId(),sellerProductEntity.get().getPrice(), sellerProductEntity.get().getStock(),sellerProductEntity.get().getSold());
        }
        else {
            throw new RuntimeException("Not Found");
        }

    }

}
