package com.cjss.ecommerce.ProductsService.repository;

import com.cjss.ecommerce.ProductsService.entity.PriceSKUEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceSKURepository extends JpaRepository<PriceSKUEntity, Integer> {

}
