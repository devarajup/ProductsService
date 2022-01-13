package com.cjss.ecommerce.ProductsService.repository;

import com.cjss.ecommerce.ProductsService.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {

}
