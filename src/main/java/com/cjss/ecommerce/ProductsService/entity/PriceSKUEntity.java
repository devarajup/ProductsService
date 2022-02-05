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
    private Integer id;

    private  Double price;
    private  String currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private ProductSKUEntity productSKUx;

    public PriceSKUEntity(Double price, String currency) {
        this.price = price;
        this.currency=currency;
    }
}
