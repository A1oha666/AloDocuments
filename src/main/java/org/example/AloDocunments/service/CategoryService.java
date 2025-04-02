package org.example.AloDocunments.service;


import org.example.AloDocunments.DTO.CategoryDTO;
import org.example.AloDocunments.pojo.Category;

import java.util.List;

public interface CategoryService {

    void updateCategory(Category category);

    void add(CategoryDTO category);

    List<Category> list();

    Category findById(Integer id);

    void delete(Integer id);

}
