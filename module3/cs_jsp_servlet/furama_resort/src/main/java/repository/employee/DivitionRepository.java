package repository.employee;

import model.employee.Divition;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivitionRepository implements IDivitionRepository {
    private final String SELECT_ALL_DIVITION = "select * from divivtion";

    @Override
    public List<Divition> selectAllDivition() {
        List<Divition> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVITION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new Divition(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Divition getDivitionById(int id) {
        return selectAllDivition().get(id);
    }
}
