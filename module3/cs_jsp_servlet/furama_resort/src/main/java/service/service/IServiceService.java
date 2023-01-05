package service.service;

import model.service.Service;

import java.util.List;

public interface IServiceService {
    List<Service> selectAllService();
    void save (Service service);
    Service getServiceById (int id);
    void update(int id, Service service);
    void remove(int id);
    List<Service> getListServiceByName(String name);
    boolean isFullName(String name);

    boolean isNumberPositive(int number);

    boolean isDoublePositive(double number);

    boolean isNullPointerException(String string);
}
