package repository.service;

import model.service.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> selectAllRenType();
    RentType getRenTypeById(int id);
}
