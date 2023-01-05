package repository.employee;

import model.user.User;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL_USER = "SELECT * FROM user";
    private final String SELECT_USER_BY_NAME = "SELECT * FROM user where username=?";

    @Override
    public List<User> selectAllUser() {
        List<User> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                list.add(new User(username,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserByName(String username) {
        Connection connection =BaseRepository.getConnectDB();
        User user =null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_NAME);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                user = new User(name,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
