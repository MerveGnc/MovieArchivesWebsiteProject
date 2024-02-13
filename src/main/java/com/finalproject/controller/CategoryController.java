package com.finalproject.controller;

import com.finalproject.model.Category;
import com.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	 private final CategoryService categoryService;
	    
	    @Autowired
	    public CategoryController(CategoryService categoryService) {
	        this.categoryService = categoryService;
	    }
	    
	    @GetMapping
	    public List<Category> getAllCategories() {
	        return categoryService.getAllCategories();
	    }
	    
	    @GetMapping("/{id}")
	    public Category getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }
	    
	    @PostMapping
	    public Category saveCategory(@RequestBody Category category) {
	        return categoryService.saveCategory(category);
	    }
	    
	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        category.setId(id);
	        return categoryService.saveCategory(category);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	    }
	
	

}
