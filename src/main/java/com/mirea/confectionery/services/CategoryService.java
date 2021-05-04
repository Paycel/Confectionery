package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Category;
import com.mirea.confectionery.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public boolean addCategory(Category category){
        if (categoryRepository.findByCategoryName(category.getCategoryName()) == null) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
