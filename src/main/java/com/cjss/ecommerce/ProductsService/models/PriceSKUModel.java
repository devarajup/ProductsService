package com.cjss.ecommerce.ProductsService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
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
    @NotNull(message = "price is requared")
    private  Double price;
    @NotEmpty(message = "Currency is requared")
    @NotNull(message = "Currency is requared")
    private  String currency;
    @JsonIgnore
    private List<PriceSKUModel> priceSKUModels;

    public PriceSKUModel(Double price, String currency) {
        this.price = price;
        this.currency = currency;
    }
}
