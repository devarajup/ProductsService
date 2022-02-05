package com.cjss.ecommerce.ProductsService.controller;

import com.cjss.ecommerce.ProductsService.models.PriceSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductSKUModel;
import com.cjss.ecommerce.ProductsService.models.ProductsModel;
import com.cjss.ecommerce.ProductsService.models.SkuIdModel;
import com.cjss.ecommerce.ProductsService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
public class ProductRest {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-products")
    public ResponseEntity<String> addProducts(@Valid @RequestBody ProductsModel model) {
        return productService.addProducts(model);
    }

    @PostMapping("/add-product-sku/{id}")
    public ResponseEntity<String>  addProductSKU(@Valid @RequestBody ProductSKUModel model, @PathVariable Integer id) {
        return productService.addProductSKU(id, model);
    }

    @PostMapping("/add-price-sku/{pid}/{sid}")
    public ResponseEntity<String> addProductSKUPrice(@Valid @RequestBody PriceSKUModel model,
                                                     @PathVariable Integer pid,
                                                     @PathVariable Integer sid
    ) {
        System.out.println(model.toString());
        return productService.addPriceSKU(pid, sid, model);
    }

    @GetMapping("/get-price")
    public Double getProductSKUPrice(@RequestParam("sid")  String sid) {

        return Double.valueOf(productService.getPriceSKU(Integer.valueOf(sid)).getPrice());
    }
        @GetMapping("/get-sku/{sid}")
        public Boolean getProductSKU (
                @PathVariable Integer sid){

            return productService.getSku(String.valueOf(sid));
        }
        }
