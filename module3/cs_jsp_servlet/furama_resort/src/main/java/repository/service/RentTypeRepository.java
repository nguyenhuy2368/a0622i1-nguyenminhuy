package repository.service;

import model.service.RentType;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import repository.BaseRepository;

import javax.swing.event.ListDataEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    private final String SELECT_ALL_RENT_TYPE = "SELECT * FROM furamar_jsp_servlet.rent_type";
    private final String SELECT_RENT_TYPE_BY_ID = "SELECT * FROM furamar_jsp_servlet.rent_type where rent_type_id = ?";

    @Override
    public List<RentType> selectAllRenType() {
        List<RentType> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new RentType(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public RentType getRenTypeById(int id) {
        RentType rentType = new RentType();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_RENT_TYPE_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString(2);
                rentType = new RentType(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentType;
    }
}
