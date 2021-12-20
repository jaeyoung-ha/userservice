package com.lgu.productservice.controller;

import com.lgu.productservice.jpa.ProductEntity;
import com.lgu.productservice.service.ProductService;
import com.lgu.productservice.vo.ResponseProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product-service")
public class ProductController {
    Environment env;
    ProductService productService;

    @Autowired
    public ProductController(Environment env, ProductService productService) {
        this.env = env;
        this.productService = productService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ResponseProduct>> getUsers() {
        Iterable<ProductEntity> userList = productService.getAllCatalog();

        List<ResponseProduct> result = new ArrayList<>();

        userList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseProduct.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
