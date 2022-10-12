package case_study.service;

public interface ContractService extends Service {
    @Override
    void addNew();

    @Override
    void display();

    @Override
    void edit();
}
