package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
}