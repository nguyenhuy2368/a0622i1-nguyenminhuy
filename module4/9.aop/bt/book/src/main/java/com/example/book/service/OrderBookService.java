package com.example.book.service;

import com.example.book.model.OrderBook;
import com.example.book.repository.IOrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderBookService implements IOrderBookService {
    @Autowired
    IOrderBookRepository orderBookRepository;

    @Override
    public List<OrderBook> findAll() {
        return orderBookRepository.findAll();
    }

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public void remove(OrderBook orderBook) {
        orderBookRepository.delete(orderBook);
    }

    @Override
    public OrderBook findById(int id) {
        return orderBookRepository.getById(id);
    }

    @Override
    public OrderBook findByCode(int code) {
        return orderBookRepository.findByCode(code);
    }
}
