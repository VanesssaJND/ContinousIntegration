package com.crisdev.projects.integracioncontinua.service;


import com.crisdev.projects.integracioncontinua.dto.SaveProduct;
import com.crisdev.projects.integracioncontinua.persistence.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    Product createOne(SaveProduct saveProduct);

    Product updateOneById(Long productId, SaveProduct saveProduct);

    Product disableOneById(Long productId);
}
