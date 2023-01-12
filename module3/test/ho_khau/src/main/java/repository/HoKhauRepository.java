package repository;

import model.HoKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoKhauRepository implements IHoKhauRepository {
    private static final String SELECT_ALL_HO_KHAU = "select * from ho_khau ;";

    private static final String INSERT_HO_KHAU = "insert into ho_khau (ma_ho_khau, ten_chu_ho, so_thanh_vien, ngay_lap_ho_khau, dia_chi) values (?, ?, ?, ?, ?) ;";

    private static final String FIND_BY_MA_HK = "select * from ho_khau where ma_ho_khau = ? ;";

    private static final String EDIT_HO_KHAU = "update ho_khau set ten_chu_ho = ?, so_thanh_vien = ?, ngay_lap_ho_khau = ?, dia_chi = ? where ma_ho_khau  = ? ;";

    private static final String DELETE_HO_KHAU = "delete from ho_khau where ma_ho_khau = ? ;";

//    private static final String FIND_HO_KHAU = "select * from ho_khau where ten_chu like ? or customer_email like ? or customer_address like ? or customer_type_id like ?;";

    @Override
    public List<HoKhau> listHoKhau() {
        List<HoKhau> hoKhaus = new ArrayList<>();

        try {

            Connection connection = BaseRepository.getConnectDB();

            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_HO_KHAU);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String maHoKhau = rs.getString("ma_ho_khau");

                String tenChuHo = rs.getString("ten_chu_ho");

                int soThanhVien = rs.getInt("so_thanh_vien");

                String ngayLapHoKhau = rs.getString("ngay_lap_ho_khau");

                String diaChi = rs.getString("dia_chi");

                hoKhaus.add(new HoKhau(maHoKhau, tenChuHo, soThanhVien, ngayLapHoKhau, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoKhaus;
    }

    @Override
    public void createHoKhau(HoKhau hoKhau) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_HO_KHAU);
            statement.setString(1, hoKhau.getMaHoKhau());
            statement.setString(2, hoKhau.getTenChuHo());
            statement.setInt(3, hoKhau.getSoThanhVien());
            statement.setString(4, hoKhau.getNgayLapHoKhau());
            statement.setString(5, hoKhau.getDiaChi());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public HoKhau findByMaHoKhau(String maHoKhau) {
        HoKhau hoKhau = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_MA_HK);
            statement.setString(1, maHoKhau);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tenChuHo = resultSet.getString("ten_chu_ho");
                int soThanhVien = resultSet.getInt("so_thanh_vien");
                String ngayLapHoKhau = resultSet.getString("ngay_lap_ho_khau");
                String diaChi = resultSet.getString("dia_chi");
                hoKhau = new HoKhau(maHoKhau, tenChuHo, soThanhVien, ngayLapHoKhau, diaChi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhau;
    }

    @Override
    public void editHoKhau(HoKhau hoKhau) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(EDIT_HO_KHAU);
            statement.setString(1, hoKhau.getTenChuHo());
            statement.setInt(2, hoKhau.getSoThanhVien());
            statement.setString(3, hoKhau.getNgayLapHoKhau());
            statement.setString(4, hoKhau.getDiaChi());
            statement.setString(5, hoKhau.getMaHoKhau());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteHoKhau(String maHoKhau) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_HO_KHAU);
            statement.setString(1,maHoKhau);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<HoKhau> findHoKhau(String nameFind) {
        return null;
    }
}
