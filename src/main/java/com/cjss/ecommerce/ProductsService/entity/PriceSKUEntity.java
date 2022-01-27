package com.cjss.ecommerce.ProductsService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_sku_table")
public class PriceSKUEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private  String price;
    private  String currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SKU_code_fk" ,unique = true)
    private ProductSKUEntity productSKUx;

    public PriceSKUEntity(String price, String currency) {
        this.price = price;
        this.currency=currency;
    }
}
