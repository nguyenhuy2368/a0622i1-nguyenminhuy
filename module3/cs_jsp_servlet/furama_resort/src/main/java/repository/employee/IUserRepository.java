package repository.employee;

import model.user.User;

import java.util.List;

public interface IUserRepository {
    List<User> selectAllUser();
    User getUserByName(String username);
}
