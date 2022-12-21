package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUser();
    boolean save(User user);
    User findById(int id);
    void update(int id, User user);
    void remove(int id);
}
