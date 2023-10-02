package co.istad.sb7springwebmvc.service;

import co.istad.sb7springwebmvc.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> loadCategories();
    Category loadCategoryById(Integer id);
    void addNewCategory(Category category);
    void updateCategoryById(Integer id, Category category);
    void deleteCategoryById(Integer id);

}
