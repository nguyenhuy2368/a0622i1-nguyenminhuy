package service.service;

import model.service.RentType;
import repository.service.IRentTypeRepository;
import repository.service.RentTypeRepository;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    IRentTypeRepository repository = new RentTypeRepository();
    @Override
    public List<RentType> selectAllRenType() {
        return repository.selectAllRenType();
    }

    @Override
    public RentType getRenTypeById(int id) {
        return repository.getRenTypeById(id);
    }
}
