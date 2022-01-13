package com.cjss.ecommerce.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSKUModel {

    private  String price;
    private  String currency;

  private List<PriceSKUModel> priceSKUModels;

    public PriceSKUModel(String price, String currency) {
        this.price = price;
        this.currency = currency;
    }
}
