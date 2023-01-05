package service.employee;

import model.user.User;
import repository.employee.IUserRepository;
import repository.employee.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository repository = new UserRepository();
    @Override
    public List<User> selectAllUser() {
        return repository.selectAllUser();
    }

    @Override
    public User getUserByName(String username) {
        return repository.getUserByName(username);
    }
}
