package case_study.service;

public interface CustomerService extends Service {
    @Override
    void addNew();

    @Override
    void display();

    @Override
    void edit();
}
