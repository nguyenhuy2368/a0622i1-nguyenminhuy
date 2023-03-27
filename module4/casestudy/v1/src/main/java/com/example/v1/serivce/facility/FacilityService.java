package com.example.v1.serivce.facility;

import com.example.v1.entity.facility.Facility;
import com.example.v1.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<Facility> findByNameAndFacilityType(String name, String typeName, Pageable pageable) {
        return facilityRepository.findByNameAndFacilityType(name, typeName, pageable);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
