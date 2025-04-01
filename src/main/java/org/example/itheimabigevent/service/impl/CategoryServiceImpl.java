package org.example.itheimabigevent.service.impl;

import org.example.itheimabigevent.DTO.CategoryDTO;
import org.example.itheimabigevent.mapper.CategoryMapper;
import org.example.itheimabigevent.pojo.Category;
import org.example.itheimabigevent.service.CategoryService;
import org.example.itheimabigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void updateCategory(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.updateCategory(category);
    }

    @Override
    public void add(CategoryDTO category) {
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateTime(LocalDateTime.now());

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return categoryMapper.list(userId);
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {

        categoryMapper.delete(id);
    }


}
