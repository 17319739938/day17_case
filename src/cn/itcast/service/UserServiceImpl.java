package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao ud=new UserDaoImpl();
    @Override
    public  List<User> findAll() {
        List<User> list = ud.findAll();
        return list;
    }

    @Override
    public User login(User loginUser) {
        User user = ud.findByUsernameandPassword(loginUser.getUsername(), loginUser.getPassword());
        return user;
    }

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        ud.deleteUser(id);
    }
}
