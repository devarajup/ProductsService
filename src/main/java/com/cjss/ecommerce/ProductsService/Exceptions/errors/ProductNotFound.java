package com.cjss.ecommerce.ProductsService.Exceptions.errors;

public class ProductNotFound extends  RuntimeException{
    public ProductNotFound() {
    }

    public ProductNotFound(String message) {
        super(message);
    }
}
