package com.example.thi.repository;

import com.example.thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select  * from product inner join product_type " +
            "on product.product_type_id = product_type.id " +
            "where product.name like %:name% and (:price is null or product.price = :price) and product_type.name like %:type% and product.is_delete= 1", nativeQuery = true)
    Page<Product> findByNameAndPriceAndType(@Param("name") String name,
                                            @Param("price") Integer price,
                                            @Param("type") String type,
                                            Pageable pageable);
   

//    @Query(value = "update product set is_delete = 0 where id = :id", nativeQuery = true)
//    void remove(@Param("id") int id);

    @Query(value = "select* from product where product.is_delete = 1", nativeQuery = true)
    List<Product> findAll();


}
