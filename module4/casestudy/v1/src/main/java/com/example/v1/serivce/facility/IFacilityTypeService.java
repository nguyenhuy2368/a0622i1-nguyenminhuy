package com.example.v1.serivce.facility;

import com.example.v1.entity.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
