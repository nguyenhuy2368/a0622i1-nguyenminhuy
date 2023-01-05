package service.service;

import model.service.ServiceType;
import repository.service.ISerivceTypeRepository;
import repository.service.ServiceTypeRpository;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService{
    ISerivceTypeRepository repository = new ServiceTypeRpository();
    @Override
    public List<ServiceType> selectAllServiceType() {
        return repository.selectAllServiceType();
    }

    @Override
    public ServiceType getServiceTypeById(int id) {
        return repository.getServiceTypeById(id);
    }
}
