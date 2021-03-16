package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
    User getById(Long id);
}
