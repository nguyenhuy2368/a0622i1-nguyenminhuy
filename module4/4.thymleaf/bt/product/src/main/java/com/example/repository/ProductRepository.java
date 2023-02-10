package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> list;

    static {
        list = new ArrayList<>();
        list.add(new Product(123, "Iphone 5", 500000));
        list.add(new Product(456, "Iphone 6", 1500000));
        list.add(new Product(789, "Iphone 7", 2500000));
        list.add(new Product(113, "Iphone 8", 4000000));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public Product findById(int id) {
        return list.get(getIndex(id));
    }

    @Override
    public void update(int id, Product product) {
        list.set(getIndex(id), product);
    }

    @Override
    public void remove(int id) {
        list.remove(getIndex(id));
    }

    private static int getIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
