package com.cjss.ecommerce.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsModel {

    @NotNull(message = "product Name required")
    @NotEmpty(message = "product Name required")
    private  String  productName;
    @NotNull(message = "description required")
    @NotEmpty(message = "description required")
    private  String  description;

   private  List<ProductSKUModel>  productSKUModels;

    public ProductsModel(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }
}
