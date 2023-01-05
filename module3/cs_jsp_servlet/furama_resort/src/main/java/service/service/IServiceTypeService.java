package service.service;

import model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> selectAllServiceType();
    ServiceType getServiceTypeById(int id);
}
