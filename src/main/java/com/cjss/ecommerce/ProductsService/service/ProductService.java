package com.cjss.ecommerce.ProductsService.service;

//import com.cjss.ecommerce.ProductsService.entity.PriceSKUEntity;
import com.cjss.ecommerce.ProductsService.entity.PriceSKUEntity;
import com.cjss.ecommerce.ProductsService.entity.ProductSKUEntity;
import com.cjss.ecommerce.ProductsService.entity.ProductsEntity;
import com.cjss.ecommerce.ProductsService.models.PriceSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductsModel;
import com.cjss.ecommerce.ProductsService.models.SkuIdModel;
import com.cjss.ecommerce.ProductsService.repository.PriceSKURepository;
import com.cjss.ecommerce.ProductsService.repository.ProductSKURepository;
import com.cjss.ecommerce.ProductsService.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
    @Autowired
    private PriceSKURepository priceSKURepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductSKURepository productSKURepository;


    public String addProducts(ProductsModel model) {
       String id= String.valueOf(productsRepository.save(getProductsEntity(model)).getProductCode());
        return "product added with Id:"+id;
    }

    public String addProductSKU(Integer id, ProductSKUModel model) {
        ProductsEntity entity = productsRepository.getById(Integer.valueOf(String.valueOf(id)));
        ProductSKUEntity skuEntity = getProductSKUEntity(model);
        skuEntity.setProducts(entity);

        String skuId= String.valueOf(productSKURepository.save(skuEntity).getSkuCode());
        return "SKU added successfully with SKU Id :"+skuId+" and product id :"+id;
    }

    public String addPriceSKU(Integer pid, Integer sid, PriceSKUModel model) {
        if (productsRepository.existsById(Integer.valueOf(String.valueOf(pid)))&&productSKURepository.existsById(Integer.valueOf(String.valueOf(sid)))) {
            PriceSKUEntity entity = getPriceSKUEntity(model);
            entity.setProductSKUx(productSKURepository.getById(Integer.valueOf(sid)));
            priceSKURepository.save(entity);
            return "Add price successfully to SKUId:"+sid;
        }
        return "not found";
    }
    public PriceSKUModel getPriceSKU( Integer sid) {
        if (productSKURepository.existsById(Integer.valueOf(String.valueOf(sid)))) {
            PriceSKUEntity entity = priceSKURepository.getById(Integer.valueOf(String.valueOf(sid)));
return new PriceSKUModel(entity.getPrice(), entity.getCurrency());
        }
        return null;
    }
    public boolean getSku(String sid){
        return  productSKURepository.existsById(Integer.valueOf(String.valueOf(Integer.valueOf(sid))));
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
