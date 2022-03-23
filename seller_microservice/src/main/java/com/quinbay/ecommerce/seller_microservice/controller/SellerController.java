package com.quinbay.ecommerce.seller_microservice.controller;

import com.quinbay.ecommerce.seller_microservice.dto.Seller;
import com.quinbay.ecommerce.seller_microservice.dto.SellerProduct;
import com.quinbay.ecommerce.seller_microservice.service.SellerProductService;
import com.quinbay.ecommerce.seller_microservice.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @Autowired
    SellerProductService sellerProductService;


    @PostMapping("/add-seller")
    public void addSeller(@RequestBody Seller seller){
        sellerService.addSeller(seller);
    }

    @PostMapping("/add-product")
    public void addProductBySeller(@RequestBody SellerProduct sellerProduct){
        sellerProductService.addProductBySeller(sellerProduct);
    }

    @GetMapping("/get-all-seller-products")
    public List<SellerProduct> getAllSellerProduct(){
        return sellerProductService.getAllSellerProduct();
    }
    @GetMapping("/get-product-byId")
    public SellerProduct getSellerProductById(@RequestParam(value = "id") Long id){
        return sellerProductService.getSellerProductById(id);
    }

    @PutMapping("/update-product")
    public void updateProductBySeller(@RequestBody SellerProduct sellerProduct){
        sellerProductService.updateProductBySeller(sellerProduct);
    }

    @DeleteMapping("/delete-product")
    public void deleteProductBySeller(@RequestParam(value = "id") Long id)
    {
        sellerProductService.deleteProductBySeller(id);
    }


}
