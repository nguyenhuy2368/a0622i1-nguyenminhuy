package service;

import model.Category;
import repository.CategoryRepository;
import repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository repository = new CategoryRepositoryImpl();
    @Override
    public List<Category> selectAllCategory() {
        return repository.selectAllCategory();
    }

    @Override
    public Category getCategoryById(int id) {
        return repository.getCategoryById(id);
    }
}
