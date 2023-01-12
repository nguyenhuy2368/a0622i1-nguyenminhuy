package repositpry;

import model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachReponsitory implements  ISachReponsitory  {
    private static final String SELECT_ALL_SACH = "select*from Sach;";
    @Override
    public List<Sach> findAll() {
        List<Sach> saches = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maSach = rs.getInt("maSach");
                String tenSach = rs.getString("tenSach");
                String tacGia = rs.getString("tacGia");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");
                Sach sach = new Sach(maSach,tenSach,tacGia,soLuong,moTa);
                saches.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saches;
    }
}
