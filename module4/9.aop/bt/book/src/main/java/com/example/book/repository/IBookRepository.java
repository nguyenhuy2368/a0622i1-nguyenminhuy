package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Integer> {
//    @Query(value = "select * from book join order_book on book.id = order_book.book_id where book.id= : id and order_book.code= :code", nativeQuery = true)
//    Book findBookLend(@Param("id")Integer id,@Param("code") int code);
}
