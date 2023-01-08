package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> selectAllProduct();

    void save(Product product);

    Product getProductById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> getListProductByName(String name);
}
