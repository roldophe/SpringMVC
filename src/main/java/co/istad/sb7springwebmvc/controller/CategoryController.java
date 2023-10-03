package co.istad.sb7springwebmvc.controller;

import co.istad.sb7springwebmvc.model.Category;
import co.istad.sb7springwebmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> loadCategories() {
        return categoryService.loadCategories();
    }

    @GetMapping("/{id}")
    Category loadCategoryById(@PathVariable("id") Integer id) {
        return categoryService.loadCategoryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void insertCategory(@RequestBody Category category) {
        categoryService.addNewCategory(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateCategoryById(@PathVariable Integer id,
                            @RequestBody Category category) {
        categoryService.updateCategoryById(id, category);
    }
}
