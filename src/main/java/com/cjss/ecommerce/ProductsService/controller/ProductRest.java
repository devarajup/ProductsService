package com.cjss.ecommerce.ProductsService.controller;

import com.cjss.ecommerce.ProductsService.models.PriceSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductsModel;
import com.cjss.ecommerce.ProductsService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductRest {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-products")
    public String addProducts(@Valid @RequestBody ProductsModel model) {
        return productService.addProducts(model);
    }

   @PostMapping("/add-product-sku/{id}")
    public Integer addProductSKU(@Valid @RequestBody ProductSKUModel model, @PathVariable Integer id) {
        return productService.addProductSKU(id, model);
    }

    @PostMapping("/add-price-sku/{pid}/{sid}")
    public String addProductSKUPrice(@Valid @RequestBody PriceSKUModel model,
                                     @PathVariable Integer pid,
                                     @PathVariable Integer sid
    ) {
        return productService.addPriceSKU(pid,sid,model);
    }
}
