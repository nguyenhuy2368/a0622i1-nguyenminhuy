package repository.service;

import model.service.ServiceType;

import java.util.List;

public interface ISerivceTypeRepository {
    List<ServiceType> selectAllServiceType();
    ServiceType getServiceTypeById(int id);
}

