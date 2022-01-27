package com.cjss.ecommerce.ProductsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
 private  String   timestamp;
 private  String   error;
private  String message;
}
