package com.elearning.demo.category;

public interface CategoryService {
    Iterable<Category> findAllCategory();
    Category findCategoryById(Long id);
    Category saveCategory(Category category);
    void  removeCategory(Long id);

}
