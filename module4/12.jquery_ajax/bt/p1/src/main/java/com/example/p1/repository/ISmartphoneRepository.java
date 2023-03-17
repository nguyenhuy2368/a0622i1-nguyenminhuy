package com.example.p1.repository;

import com.example.p1.model.Smartphone;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {

}
