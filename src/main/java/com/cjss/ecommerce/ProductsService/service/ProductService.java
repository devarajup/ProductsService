package com.cjss.ecommerce.ProductsService.service;

//import com.cjss.ecommerce.ProductsService.entity.PriceSKUEntity;
import com.cjss.ecommerce.ProductsService.Exceptions.errors.DuplicateProduct;
import com.cjss.ecommerce.ProductsService.Exceptions.errors.ProductNotFound;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    public ResponseEntity<String> addProducts(ProductsModel model) {
     try {
         String id= String.valueOf(productsRepository.save(getProductsEntity(model)).getProductCode());
         return new ResponseEntity<String> ("Product  Id:"+id,HttpStatus.ACCEPTED);
     }catch (Exception ex){
         throw  new DuplicateProduct("Duplicate product  Name  Not Allowed");
     }

    }

    public ResponseEntity<String> addProductSKU(Integer id, ProductSKUModel model) {
    try {
        ProductsEntity entity = productsRepository.getById(Integer.valueOf(String.valueOf(id)));

        ProductSKUEntity skuEntity = getProductSKUEntity(model);
        skuEntity.setProducts(entity);
        String skuId= String.valueOf(productSKURepository.save(skuEntity).getSkuCode());
        return new ResponseEntity<String>("SKU added successfully with SKU Id :"+skuId+" and product id :"+id,HttpStatus.ACCEPTED);
    }catch (Exception ex){
        throw  new ProductNotFound("This Product not exist in Inventory");
    }
    }

    public ResponseEntity<String>  addPriceSKU(Integer pid, Integer sid, PriceSKUModel model) {
      try {
          System.out.println(pid+" "+sid+" "+model.toString());
          if (productsRepository.existsById(pid)&&productSKURepository.existsById(sid)) {
              PriceSKUEntity entity = getPriceSKUEntity(model);
              ProductSKUEntity productSKU =productSKURepository.getById(sid);
//              productSKU.setPriceSKUEntities(null);
              entity.setProductSKUx(productSKU);
              priceSKURepository.save(entity);
              return  new ResponseEntity<String>("Add price successfully to SKUId:"+sid,HttpStatus.ACCEPTED);
          } }catch (Exception ex){
          throw new DuplicateProduct("Duplicate not allowed");
      }
          return new ResponseEntity<String>("Not found details",HttpStatus.NOT_FOUND);

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
