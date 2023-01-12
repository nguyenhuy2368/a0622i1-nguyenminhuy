package service;

import model.HoKhau;
import repository.HoKhauRepository;
import repository.IHoKhauRepository;

import java.util.List;

public class HoKhauService implements IHoKhauService {
    IHoKhauRepository repository = new HoKhauRepository();

    @Override
    public List<HoKhau> listHoKhau() {
        return repository.listHoKhau();
    }

    @Override
    public void createHoKhau(HoKhau hoKhau) {
        repository.createHoKhau(hoKhau);
    }

    @Override
    public HoKhau findByMaHoKhau(String maHoKhau) {
        return findByMaHoKhau(maHoKhau);
    }

    @Override
    public void editHoKhau(HoKhau hoKhau) {
        repository.editHoKhau(hoKhau);
    }

    @Override
    public void deleteHoKhau(String maHoKhau) {
        repository.deleteHoKhau(maHoKhau);
    }
}
