package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User login(User loginUser);
    void addUser(User user);
    void deleteUser(int id);
}
