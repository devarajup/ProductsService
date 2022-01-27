package com.cjss.ecommerce.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSKUModel {
    @NotEmpty(message = "price is requared")
    @NotNull(message = "price is requared")
    private  String price;
    @NotEmpty(message = "Currency is requared")
    @NotNull(message = "Currency is requared")
    private  String currency;

  private List<PriceSKUModel> priceSKUModels;

    public PriceSKUModel(String price, String currency) {
        this.price = price;
        this.currency = currency;
    }
}
