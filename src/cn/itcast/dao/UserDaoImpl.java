package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findByUsernameandPassword(String username, String password) {
        try {
            String sql ="select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql ="insert user values (null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql,user.getName(),user.getSex(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
