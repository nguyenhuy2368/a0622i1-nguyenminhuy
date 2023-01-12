package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepositoryInt {
    List<Customer> selectAllCustomer();
    void save (Customer customer);
    void remove(String customerid);
    Customer findCustomerById(String customerId);
    void update(String customerId, Customer customer);
    String findNameCustomer(String customerId);
//    int getLastCustomerId ();
}
