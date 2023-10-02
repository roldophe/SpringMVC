package co.istad.sb7springwebmvc.service.impl;

import co.istad.sb7springwebmvc.model.Category;
import co.istad.sb7springwebmvc.repository.CategoryRepository;
import co.istad.sb7springwebmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> loadCategories() {
        return categoryRepository.selectCategories();
    }

    @Override
    public Category loadCategoryById(Integer id) {
        return categoryRepository.selectCategoryByID(id);
    }

    @Override
    public void addNewCategory(Category category) {
        categoryRepository.insertCategory(category);
    }

    @Override
    public void updateCategoryById(Integer id, Category category) {
        //category.setId(id);
        categoryRepository.updateCategoryByID(id,category);
    }

    @Override
    public void deleteCategoryById(Integer id) {

    }
}
