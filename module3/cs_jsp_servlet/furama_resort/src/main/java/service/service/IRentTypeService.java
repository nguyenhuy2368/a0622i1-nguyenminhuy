package service.service;

import model.service.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> selectAllRenType();
    RentType getRenTypeById(int id);
}
