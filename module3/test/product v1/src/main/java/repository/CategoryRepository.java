package repository;

import model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> selectAllCategory();

    Category getCategoryById(int id);
}
