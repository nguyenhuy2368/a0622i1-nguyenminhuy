package repository;

import model.ThanhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThanhVienRepository implements IThanhVienRepository{
    private static final String SELECT_THANH_VIEN = "select * from thanh_vien ;";
    @Override
    public List<ThanhVien> listThanhVien() {
        List<ThanhVien> thanhViens = new ArrayList<>();
        Connection connection =BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_THANH_VIEN);
            ResultSet resultSet = statement .executeQuery();
            while (resultSet.next()){
                int cmnd = resultSet.getInt("cmnd");
                String hoTen = resultSet.getString("ho_ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                String maHoKhau = resultSet.getString("ma_ho_khau");
                thanhViens.add(new ThanhVien(cmnd,hoTen,ngaySinh,maHoKhau));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return thanhViens;
    }
}
