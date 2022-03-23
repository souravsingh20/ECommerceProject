package com.quinbay.ecommerce.seller_microservice.service;


import com.quinbay.ecommerce.seller_microservice.dto.SellerProduct;

import java.util.List;

public interface SellerProductService {

    void addProductBySeller(SellerProduct sellerProduct);
    SellerProduct updateProductBySeller(SellerProduct sellerProduct);
    void deleteProductBySeller(Long id);
    SellerProduct getSellerProductById(Long id);
    List<SellerProduct> getAllSellerProduct();
}
