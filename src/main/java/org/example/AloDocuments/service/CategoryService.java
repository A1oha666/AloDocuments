package org.example.AloDocuments.service;


import org.example.AloDocuments.DTO.CategoryDTO;
import org.example.AloDocuments.pojo.Category;

import java.util.List;

public interface CategoryService {

    void updateCategory(Category category);

    void add(CategoryDTO category);

    List<Category> list();

    Category findById(Integer id);

    void delete(Integer id);

}
