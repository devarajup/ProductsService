package com.cjss.ecommerce.ProductsService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product_sku_table")
public class ProductSKUEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skuCode;
    private  String size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_code_fk")
    private ProductsEntity products;

    @OneToMany(mappedBy = "productSKUx" )
    private   List<PriceSKUEntity> priceSKUEntities;

    public ProductSKUEntity(String size) {
        this.size = size;
    }
}
