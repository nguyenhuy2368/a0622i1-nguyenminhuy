package repository.employee;

import model.employee.EducationDegree;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository{
    private final String SELECT_ALL_EDUCATION_DEGREE="select * from education_degree";
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> list =new ArrayList<>();
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new EducationDegree(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public EducationDegree getEducationDegreeById(int id) {
        return selectAllEducationDegree().get(id);
    }
}
