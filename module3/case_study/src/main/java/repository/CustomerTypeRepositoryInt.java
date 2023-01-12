package repository;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeRepositoryInt {
    List<CustomerType> selectAllCustomerType() ;
    CustomerType findCustomerTypeById(String customerTypeId);
}
