package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findByUsernameandPassword(String username,String password);
    void addUser(User user);

    void deleteUser(int id);
}
