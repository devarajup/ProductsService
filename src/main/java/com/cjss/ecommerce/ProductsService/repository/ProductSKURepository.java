package com.cjss.ecommerce.ProductsService.repository;

import com.cjss.ecommerce.ProductsService.entity.ProductSKUEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSKURepository extends JpaRepository<ProductSKUEntity, Integer> {
}
