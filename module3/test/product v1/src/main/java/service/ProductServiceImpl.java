package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public List<Product> selectAllProduct() {
        return repository.selectAllProduct();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return repository.getProductById(id);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id, product);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<Product> getListProductByName(String name) {
        return repository.getListProductByName(name);
    }
}
