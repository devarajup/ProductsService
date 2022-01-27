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
       Integer id= productsRepository.save(getProductsEntity(model)).getProductCode();
        return "product added with Id:"+id;
    }

    public String addProductSKU(Integer id, ProductSKUModel model) {
        ProductsEntity entity = productsRepository.getById(id);
        ProductSKUEntity skuEntity = getProductSKUEntity(model);
        skuEntity.setProducts(entity);

        Integer skuId= productSKURepository.save(skuEntity).getSkuCode();
        return "SKU added successfully with SKU Id :"+skuId+" and product id :"+id;
    }

    public String addPriceSKU(Integer pid, Integer sid, PriceSKUModel model) {
        if (productsRepository.existsById(pid)&&productSKURepository.existsById(sid)) {
            PriceSKUEntity entity = getPriceSKUEntity(model);
            entity.setProductSKUx(productSKURepository.getById(sid));
            priceSKURepository.save(entity);
            return "Add price successfully to SKUId:"+sid;
        }
        return "not found";
    }
    public PriceSKUModel getPriceSKU(Integer pid, Integer sid) {
        if (productsRepository.existsById(pid)&&productSKURepository.existsById(sid)) {
            PriceSKUEntity entity = priceSKURepository.getById(sid);
return new PriceSKUModel(entity.getPrice(), entity.getCurrency());
        }
        return null;
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
