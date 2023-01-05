package service.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomer();
    void save(Customer customer);
    void update(int id, Customer customer);
    void delete(int id);
    List<Customer> getCustomerByName(String name);
    Customer getCustomerById(int id);
}
