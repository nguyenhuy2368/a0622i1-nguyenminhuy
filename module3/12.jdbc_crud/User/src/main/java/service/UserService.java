package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository repository = new UserRepository();

    @Override
    public List<User> selectAllUser() {
        return repository.selectAllUser();
    }

    @Override
    public boolean save(User user) {
        return repository.save(user);
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, User user) {
        repository.update(id, user);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<User> findByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<User> sortName() {
        return repository.sortName();
    }
}
