package com.elearning.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories")
    public List<Category> categories() {return categoryService.findAllCategory();}

    @GetMapping("/admin/categories/{id}")
    public Category findCategoryById(@PathVariable(value = "id") Long id) { return categoryService.findCategoryById(id); }

    @PostMapping("/admin/categories")
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/admin/categories")
    public void updateStudy(@RequestBody Category category) { categoryService.saveCategory(category); }

    @DeleteMapping("/admin/categories/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        categoryService.removeCategory(id);
    }
}
