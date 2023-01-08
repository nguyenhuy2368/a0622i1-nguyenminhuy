package service;

import model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectAllCategory();

    Category getCategoryById(int id);
}
