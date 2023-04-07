package com.example.demo.service;


import com.example.demo.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {
    void update(Bill bill);

    Page<Bill> findAll(Pageable pageable);

    void deleteById(Integer id);

    void save(Bill bill);

    Bill findById(Integer id);

    Page<Bill> findAllByRequirement(String keyword, Pageable pageable);
}
