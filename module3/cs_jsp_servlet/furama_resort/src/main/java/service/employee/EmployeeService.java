package service.employee;

import model.employee.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository repository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return repository.selectAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (int i = 0; i < repository.selectAllEmployee().size(); i++) {
            if (repository.selectAllEmployee().get(i).getId() == id) {
                return repository.selectAllEmployee().get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        repository.update(id, employee);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return repository.getEmployeeByName(name);
    }
}
