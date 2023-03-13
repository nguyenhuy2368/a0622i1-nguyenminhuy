package com.example.book.repository;

import com.example.book.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderBookRepository extends JpaRepository<OrderBook,Integer> {
    OrderBook findByCode (int code);
    @Query(value = "select * from order_book join book on order_book.book_id = book.id where book.id= :id and order_book.code= :code", nativeQuery = true)
    OrderBook findOrderReturn(@Param("id")Integer id, @Param("code") String code);
}
