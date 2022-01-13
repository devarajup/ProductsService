package com.cjss.ecommerce.ProductsService.service;

import com.cjss.ecommerce.ProductsService.entity.PriceSKUEntity;
import com.cjss.ecommerce.ProductsService.entity.ProductSKUEntity;
import com.cjss.ecommerce.ProductsService.entity.ProductsEntity;
import com.cjss.ecommerce.ProductsService.models.PriceSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductsModel;
import com.cjss.ecommerce.ProductsService.repository.PriceSKURepository;
import com.cjss.ecommerce.ProductsService.repository.ProductSKURepository;
import com.cjss.ecommerce.ProductsService.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private PriceSKURepository priceSKURepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductSKURepository productSKURepository;


    public String addProducts(ProductsModel model) {
        productsRepository.save(getProductsEntity(model));
        return "product added";
    }

    public Integer addProductSKU(Integer id, ProductSKUModel model) {
        ProductsEntity entity = productsRepository.getById(id);
        ProductSKUEntity skuEntity = getProductSKUEntity(model);
        skuEntity.setProducts(entity);

        return productSKURepository.save(skuEntity).getSkuCode();
    }

    public String addPriceSKU(Integer pid, Integer sid, PriceSKUModel model) {
        if (productsRepository.existsById(pid)&&productSKURepository.existsById(sid)) {
            PriceSKUEntity entity = getPriceSKUEntity(model);
            entity.setProductSKUx(productSKURepository.getById(sid));
            priceSKURepository.save(entity);
            return "Add price successfully";
        }
        return "not found";
    }
    private ProductsEntity getProductsEntity(ProductsModel model) {
        return new ProductsEntity(model.getProductName(), model.getDescription());
    }

    private ProductSKUEntity getProductSKUEntity(ProductSKUModel model) {
        return new ProductSKUEntity(model.getSize());
    }
    private PriceSKUEntity getPriceSKUEntity(PriceSKUModel model){
        return  new PriceSKUEntity(model.getPrice(), model.getCurrency());
    }


}
