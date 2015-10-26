package com.researchdwit.rara.service.dao;

import com.researchdwit.rara.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by saneel on 10/26/15.
 */
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UserInfo getUserInfo(String username) {
        String sql = "SELECT u.username,u.password,r.role FROM user u  INNER JOIN user_role ur ON u.id = ur.user_id INNER JOIN role r ON ur.role_id = r.id WHERE u.username=?; ";
        UserInfo userInfo = jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

                UserInfo user = new UserInfo();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                return user;
            }
        });

        return userInfo;
    }

}

