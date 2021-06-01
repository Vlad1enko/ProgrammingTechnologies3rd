package ua.kpi.library.service;

import ua.kpi.library.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Integer id);
}
