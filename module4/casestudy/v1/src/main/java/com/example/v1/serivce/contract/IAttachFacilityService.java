package com.example.v1.serivce.contract;

import com.example.v1.entity.contract.AttachFacility;

import java.util.List;
import java.util.Optional;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    Optional<AttachFacility> findById(Integer id);

    AttachFacility save(AttachFacility attachFacility);

    void remove(Integer id);
}
