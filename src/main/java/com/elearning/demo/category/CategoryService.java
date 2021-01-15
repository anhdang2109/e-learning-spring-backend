package com.elearning.demo.category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findCategoryById(Long id);
    Category saveCategory(Category category);
    void  removeCategory(Long id);

}
