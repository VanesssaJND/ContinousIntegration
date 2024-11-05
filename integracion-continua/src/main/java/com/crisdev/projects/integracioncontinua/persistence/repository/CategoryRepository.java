package com.crisdev.projects.integracioncontinua.persistence.repository;


import com.crisdev.projects.integracioncontinua.persistence.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

