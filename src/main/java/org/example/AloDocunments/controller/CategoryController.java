package org.example.AloDocunments.controller;

import org.example.AloDocunments.DTO.CategoryDTO;
import org.example.AloDocunments.pojo.Category;
import org.example.AloDocunments.pojo.Result;
import org.example.AloDocunments.service.CategoryService;
import org.example.AloDocunments.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public Result<Object> addCategory(@RequestBody @Validated/*数据校验*/ CategoryDTO category) {
        categoryService.add(category);
        return Result.success("添加成功");
    }

    @GetMapping()
    public Result<List<Category>> getCategory() {
         return Result.success(categoryService.list());
    }

    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam Integer id) {
        Category c = categoryService.findById(id);
        if (c == null)
            return Result.error("文章id不存在！");
        return Result.success(c);
    }

    @PutMapping
    public Result<Object> updateCategory(@RequestBody @Validated Category category) {
        categoryService.updateCategory(category);
        return Result.success();
    }

    @DeleteMapping
    public Result<Object> deleteCategory(@RequestParam Integer id) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Category c = categoryService.findById(userId);
        if (c == null){
            return Result.error("此分类不存在！");
        }
        categoryService.delete(id);
        return Result.success();
    }
}
