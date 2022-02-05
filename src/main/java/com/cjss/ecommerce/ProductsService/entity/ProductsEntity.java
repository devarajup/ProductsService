package com.cjss.ecommerce.ProductsService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_table")
public class ProductsEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Integer   productCode;
    @Column(unique = true)
    @NotNull(message = "Product should be not null")
    private  String  productName;
    @NotNull(message = "Description should be not null")
    private  String  description;

    @OneToMany(mappedBy = "products")
    private List<ProductSKUEntity> productSKU;





    public ProductsEntity(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }


}
