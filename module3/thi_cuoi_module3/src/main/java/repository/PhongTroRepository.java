package repository;

import model.PhongTro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepository implements IPhongTroRepository{
    public final String SELECT_ALL_PHONG_TRO = "select maPhongTro,tenNguoiThue, sdt, ngayBatDau, hinh_thuc_thanh_toan.idThanhToan,ghiChu from phong_tro join hinh_thuc_thanh_toan on phong_tro.idThanhToan = hinh_thuc_thanh_toan.idThanhToan;";
    public final String ADD_PHONG = "insert into phong_tro(tenNguoiThue, sdt, ngayBatDau, idThanhToan, ghiChu) values (?,?,?,?,?)";
    public final String DELETE_PHONG_BY_ID = "delete from phong_tro where maPhongTro = ?;";
    public  final String SELECT_PHONG_BY_ID = "select * from phong_tro where maPhongTro = ?";
    public  final String SELECT_PHONG_BY_NAME = "select * from phong_tro where tenNguoiThue = ?";
    @Override
    public List<model.PhongTro> findAll() {
        List<PhongTro> results = new ArrayList<>();
        Connection conn = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PHONG_TRO);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maPhongTro = rs.getInt("maPhongTro");
                String tenNguoiThue = rs.getString("tenNguoiThue");
                String sdt = rs.getString("sdt");
                String ngayBatDau = rs.getString("ngayBatDau");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");
                results.add(new PhongTro(maPhongTro,tenNguoiThue,sdt,ngayBatDau,idThanhToan,ghiChu));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }

    @Override
    public void addPhong(PhongTro phongTro) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_PHONG);
            ps.setString(1, phongTro.getTenNguoiThue());
            ps.setString(2, phongTro.getSdt());
            ps.setString(3, phongTro.getNgayBatDau());
            ps.setInt(4, phongTro.getIdThanhToan());
            ps.setString(5, phongTro.getGhiChu());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeById(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_PHONG_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public PhongTro findById(int id) {
        PhongTro phongTro = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PHONG_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                int maPhongTro = rs.getInt("maPhongTro");
                String tenNguoiThue = rs.getString("tenNguoiThue");
                String sdt = rs.getString("sdt");
                String ngayBatDau = rs.getString("ngayBatDau");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");

                phongTro = new PhongTro(maPhongTro,tenNguoiThue,sdt,ngayBatDau,idThanhToan,ghiChu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongTro;
    }

    @Override
    public List<PhongTro> findByName(String phongName) {
        List<PhongTro> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PHONG_BY_NAME);
            statement.setString(1, "%" + phongName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int maPhongTro = rs.getInt("maPhongTro");
                String tenNguoiThue = rs.getString("tenNguoiThue");
                String sdt = rs.getString("sdt");
                String ngayBatDau = rs.getString("ngayBatDau");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");

                PhongTro phongTro = new PhongTro(maPhongTro,tenNguoiThue,sdt,ngayBatDau,idThanhToan,ghiChu);
                list.add(phongTro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
