package com.example.v1.serivce.contract;

import com.example.v1.entity.contract.AttachFacility;
import com.example.v1.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(Integer id) {
        return attachFacilityRepository.findById(id);
    }

    @Override
    public AttachFacility save(AttachFacility attachFacility) {
        return attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void remove(Integer id) {
        attachFacilityRepository.deleteById(id);
    }
}
