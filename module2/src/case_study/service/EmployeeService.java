package case_study.service;

public interface EmployeeService extends Service {
    @Override
    void addNew();

    @Override
    void display();

    @Override
    void edit();
}
