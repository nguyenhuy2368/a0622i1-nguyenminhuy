package repository;

import model.Product;

import java.util.List;

public interface IProductDAO extends GeneralService<Product> {
   public List<Product> findByName(String productName);

}
