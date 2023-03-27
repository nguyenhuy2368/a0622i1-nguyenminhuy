package com.example.v1.serivce.facility;

import com.example.v1.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    Page<Facility> findByNameAndFacilityType(String name,
                                             String typeName,
                                             Pageable pageable);

    Optional<Facility> findById(int id);

    void save(Facility facility);
}
