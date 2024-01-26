package com.example.reservehaja.service.product;

import com.example.reservehaja.data.dto.product.ProductDto;
import com.example.reservehaja.data.dto.product.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
