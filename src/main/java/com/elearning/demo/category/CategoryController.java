package com.elearning.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @PutMapping("/admin/categories/{id}")
    public void updateStudy(@PathVariable(value = "id") Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        categoryService.removeCategory(id);
    }
}
