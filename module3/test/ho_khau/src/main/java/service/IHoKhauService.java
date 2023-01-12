package service;

import model.HoKhau;

import java.util.List;

public interface IHoKhauService {
    List<HoKhau> listHoKhau();
    void createHoKhau(HoKhau hoKhau);
    HoKhau findByMaHoKhau(String maHoKhau);
    void editHoKhau(HoKhau hoKhau);
    void deleteHoKhau(String maHoKhau);
//    List<HoKhau> findHoKhau(String nameFind);
}
