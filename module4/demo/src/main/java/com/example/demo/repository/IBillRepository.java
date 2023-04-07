package com.example.demo.repository;

import com.example.demo.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "SELECT * FROM Bill b where b.quantity like %?1%",
            countQuery = "SELECT * FROM Bill b where b.quantity like %?1% ", nativeQuery = true)
    Page<Bill> findAllByRequirement(@Param("keyword") String keyword, Pageable pageable);
}
