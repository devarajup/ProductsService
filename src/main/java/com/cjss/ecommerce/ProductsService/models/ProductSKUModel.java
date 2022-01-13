package com.cjss.ecommerce.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSKUModel {

   private  String size;
   private ProductsModel productsModel;

   public ProductSKUModel(String size) {
        this.size = size;
   }

}
