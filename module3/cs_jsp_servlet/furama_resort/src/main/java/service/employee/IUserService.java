package service.employee;

import model.user.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUser();
    User getUserByName(String username);
}
