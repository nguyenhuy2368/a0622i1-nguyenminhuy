package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void remove(Book book);
}
