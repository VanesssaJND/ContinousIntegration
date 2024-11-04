package com.crisdev.projects.integracioncontinua.persistence.repository;


import com.crisdev.projects.integracioncontinua.persistence.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
