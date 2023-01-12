package service;

import model.HoKhau;
import repository.HoKhauRepository;
import repository.IHoKhauRepository;

import java.util.List;

public class HoKhauService implements IHoKhauService{
    private IHoKhauRepository hoKhauRepository = new HoKhauRepository();
    @Override
    public List<HoKhau> selectAllHoKhau() {
        return hoKhauRepository.selectAllHoKhau();
    }

    @Override
    public HoKhau selectHoKhau(int id) {
        return hoKhauRepository.selectHoKhau(id);
    }

    @Override
    public void insertHoKhau(HoKhau hoKhau) {
        hoKhauRepository.insertHoKhau(hoKhau);
    }

    @Override
    public boolean updateHoKhau(HoKhau hoKhau) {
        return hoKhauRepository.updateHoKhau(hoKhau);
    }
}
