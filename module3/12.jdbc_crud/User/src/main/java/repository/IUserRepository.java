package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> selectAllUser();
    boolean save(User user);
    User findById(int id);
    void update(int id, User user);
    void remove(int id);
    List<User> findByCountry(String country);

    List<User> sortName();
}
