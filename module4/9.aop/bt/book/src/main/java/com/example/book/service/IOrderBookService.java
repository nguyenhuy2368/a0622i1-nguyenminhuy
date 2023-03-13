package com.example.book.service;

import com.example.book.model.OrderBook;

import java.util.List;

public interface IOrderBookService {
    List<OrderBook> findAll();
    void save(OrderBook orderBook);
    void remove(OrderBook orderBook);
    OrderBook findById(int id);
    OrderBook findByCode (int code);
}
