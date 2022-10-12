package case_study.service;

public interface BookingService extends Service {
    @Override
    void addNew();

    @Override
    void display();

    @Override
    void edit();
}
