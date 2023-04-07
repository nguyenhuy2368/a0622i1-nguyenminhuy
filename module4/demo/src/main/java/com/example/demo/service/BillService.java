package com.example.demo.service;

import com.example.demo.model.Bill;
import com.example.demo.repository.IBillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    IBillRepository repository;

    @Override
    public void update(Bill bill) {
        repository.save(bill);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Bill bill) {
        repository.save(bill);
    }

    @Override
    public Bill findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Bill> findAllByRequirement(String keyword, Pageable pageable) {
        return repository.findAllByRequirement(keyword, pageable);
    }
}
