package com.example.reservehaja.controller;

import com.example.reservehaja.data.dao.dto.ChangeProductNameDto;
import com.example.reservehaja.data.dao.dto.ProductDto;
import com.example.reservehaja.data.dao.dto.ProductResponseDto;
import com.example.reservehaja.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto
    ) throws Exception {

        ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
