package com.example.v1.repository.contract;

import com.example.v1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContracRepository extends JpaRepository<Contract,Integer>{
}
