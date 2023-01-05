package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository repository = new CustomerRepository();

    @Override
    public List<Customer> selectAllCustomer() {
        return repository.selectAllCustomer();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        repository.update(id, customer);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        return repository.getCustomerByName(name);
    }

    @Override
    public Customer getCustomerById(int id) {
        for (int i = 0; i < selectAllCustomer().size(); i++) {
            if (selectAllCustomer().get(i).getId() == id){
                return selectAllCustomer().get(i);
            }
        }
        return null;
    }
}
