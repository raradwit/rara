package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import test.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by saneel on 8/23/15.
 */
@Repository
public class UserRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public User getUser(int id) {
        return jdbc.queryForObject("select * from user where id=?",new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getInt("id"),resultSet.getInt("roll"),resultSet.getString("name"),resultSet.getString("alias"));
                return user;
            }
        },id);
    }

    public void insert(User user) {
        jdbc.update("insert into user(name,roll,alias) values (?,?,?)",user.getName(),user.getRoll(),user.getAlias());
    }

    public List<User> getAllUser() {
        List<User> allUsers = jdbc.query("select * from user order by id desc",new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getInt("id"),resultSet.getInt("roll"),resultSet.getString("name"),resultSet.getString("alias"));
            }
        });

        return allUsers;
    }

    public User edit(int id) {
        return jdbc.queryForObject("select * from user where id=?",new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getInt("id"),resultSet.getInt("roll"),resultSet.getString("name"),resultSet.getString("alias"));
                return user;
            }
        },id);
    }

    public void update(User user) {
        jdbc.update("update user set name=?,roll=?,alias=? where id =? ",user.getName(),user.getRoll(),user.getAlias(),user.getId());
    }

    public void delete(int id) {
        jdbc.update("delete from user where id = ?",id);
    }
}
