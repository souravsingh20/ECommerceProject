package com.quinbay.ecommerce.seller_microservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="seller_product")
public class SellerProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long productId;

    @NotNull
    private Long price;
    private Integer stock;
    private Integer sold;

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    SellerEntity sellerEntity;

    public SellerProductEntity() {};

    public SellerProductEntity(Long id, Long productId, Long price, Integer stock, Integer sold, Long sellerId) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
        this.sellerEntity.setId(sellerId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerEntity.getId();
    }

    public void setSellerId(Long sellerId) {
        this.sellerEntity.setId(sellerId);
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

    public SellerEntity getSellerEntity() {
        return sellerEntity;
    }

    public void setSellerEntity(SellerEntity sellerEntity) {
        this.sellerEntity = sellerEntity;
    }
}

