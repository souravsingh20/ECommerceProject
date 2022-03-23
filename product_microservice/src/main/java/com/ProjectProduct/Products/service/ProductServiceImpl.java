package com.ProjectProduct.Products.service;

import com.ProjectProduct.Products.dto.Product;
import com.ProjectProduct.Products.entity.ProductEntity;
import com.ProjectProduct.Products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProducts(Product product) {
        ProductEntity productEntity = new ProductEntity ();
        Iterable<ProductEntity> productEntities = productRepository.findAll();

        int productCount = 0;
        String productName = product.getName();
        for(ProductEntity prod : productEntities){
            if(productName.equals(prod.getName())){
//                feignController.addToSeller();
                productCount++;
                break;
            }
        }
        if(productCount==0){
            productEntity.setStock(product.getStock());
                productEntity.setPrice(product.getPrice());
                productEntity.setImage(product.getImage());
                productEntity.setDetails(product.getDetails());
                productEntity.setName(product.getName());
                productEntity.setId(product.getId());
                productEntity.setCategory (product.getCategory ());
                productEntity.setSellerId (product.getSellerId ());
                productRepository.save(productEntity);
        }

    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<Product> list = new ArrayList<> ();
        for (ProductEntity prod : productEntities) {
            list.add(new Product(prod.getId(),
                    prod.getSellerId(),
                    prod.getName(),
                    prod.getDetails(),
                    prod.getImage(),
                    prod.getCategory (),
                    prod.getPrice(),
                    prod.getStock()));
        }
        return list;
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<ProductEntity> productEntity = productRepository.findById (id);
        if (productEntity.isPresent ( )) {
            return new Product (productEntity.get ( ).getId ( ), productEntity.get ( ).getSellerId ( ), productEntity.get ( ).getName ( ), productEntity.get ( ).getDetails ( ), productEntity.get ( ).getImage ( ), productEntity.get ( ).getCategory ( ), productEntity.get ( ).getPrice ( ), productEntity.get ( ).getStock ( ));
        } else {
            throw new RuntimeException ("Not Found");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        for(ProductEntity productEntity : productRepository.findAll()){
            if(productEntity.getId()==id){
                productRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Iterable<ProductEntity> productEntityIterable = productRepository.findAll();
        for(ProductEntity productEntity :productEntityIterable){
            if(productEntity.getId() == product.getId()){
                productEntity.setStock(product.getStock());
                productEntity.setPrice (product.getPrice ());
                productRepository.save(productEntity);
            }
        }
        return product;
    }

//    @Override
//    public List<ProductEntity> getProductByName(String name) {
////        return (List<ProductEntity>) productRepository.getProductByName (name);
//        return null;
//    }

    @Override
    public List<ProductEntity> getProductByCategory(String category){
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<ProductEntity> list = new ArrayList<> ();
        for(ProductEntity prod: productEntities){
            if(prod.getCategory ().equals (category)){
                list.add(prod);
            }
        }

       return list;
    }

}
