package com.cjss.ecommerce.ProductsService.Exceptions.errors;

public class DuplicateProduct extends  RuntimeException{
    public DuplicateProduct() {
    }

    public DuplicateProduct(String message) {
        super(message);
    }
}
