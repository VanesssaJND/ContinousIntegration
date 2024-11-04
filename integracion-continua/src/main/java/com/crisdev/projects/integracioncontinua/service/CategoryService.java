package com.crisdev.projects.integracioncontinua.service;

import com.crisdev.projects.integracioncontinua.dto.SaveCategory;
import com.crisdev.projects.integracioncontinua.persistence.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOneById(Long categoryId);

    Category createOne(SaveCategory saveCategory);

    Category updateOneById(Long categoryId, SaveCategory saveCategory);

    Category disableOneById(Long categoryId);
}
