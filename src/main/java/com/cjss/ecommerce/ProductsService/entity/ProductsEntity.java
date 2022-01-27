package com.cjss.ecommerce.ProductsService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_table")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer    productCode;
    @Column(unique = true)
    private  String  productName;
    private  String  description;

    @OneToMany(mappedBy = "products")
    private List<ProductSKUEntity> productSKU;

    public ProductsEntity(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }


}
