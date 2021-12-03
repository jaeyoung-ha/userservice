package com.lgu.catalogservice.service;

import com.lgu.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalog();
}
