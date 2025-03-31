package org.example.itheimabigevent.service;


import org.example.itheimabigevent.pojo.Category;

import java.util.List;

public interface CategoryService {

    void updateCategory(Category category);

    void add(Category category);

    List<Category> list();

    Category findById(Integer id);
}
