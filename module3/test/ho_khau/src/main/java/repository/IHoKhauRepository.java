package repository;

import model.HoKhau;

import java.util.List;

public interface IHoKhauRepository {
    List<HoKhau> listHoKhau();
    void createHoKhau(HoKhau hoKhau);
    HoKhau findByMaHoKhau(String maHoKhau);
    void editHoKhau(HoKhau hoKhau);
    void deleteHoKhau(String maHoKhau);
    List<HoKhau> findHoKhau(String nameFind);
}
