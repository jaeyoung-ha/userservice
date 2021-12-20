package com.lgu.productservice.service;

import com.lgu.productservice.jpa.ProductEntity;

public interface ProductService {
    Iterable<ProductEntity> getAllCatalog();
}
