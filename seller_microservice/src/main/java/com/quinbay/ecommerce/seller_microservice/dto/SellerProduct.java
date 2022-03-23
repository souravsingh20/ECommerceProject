package com.quinbay.ecommerce.seller_microservice.dto;

public class SellerProduct {

    private Long id;
    private Long sellerId;
    private Long productId;
    private Long price;
    private Integer stock;
    private Integer sold;

    public SellerProduct() {};

    public SellerProduct(Long id, Long sellerId, Long productId, Long price, Integer stock, Integer sold) {
        this.id = id;
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setMerchantId(Long merchantId) {
        this.sellerId = merchantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
