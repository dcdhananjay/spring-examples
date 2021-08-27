package com.example.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

    @Autowired
    private JdbcTemplate jdbc;

    public List<UserBean> findAll() {
        List<UserBean> users = jdbc.query("select * from UserBean", new UserRowMapper());
        return users;
    }

    public UserBean save(UserBean user) {
        Grade grade = calculateGrade(user.getSalary());
        String sql = "insert into userbean values(" + user.getId() + ",'" + user.getName() + "','" + user.getDob() + "'"
                + "," + user.getSalary() + ",'" + grade + "')";
        jdbc.execute(sql);
        return user;
    }

    public UserBean findOne(int id) {
        String sql = "SELECT * FROM USERBEAN WHERE ID = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    public void removeUser(int id) {
        String sql = "delete from userbean where id = " + id;
        jdbc.execute(sql);
    }

    public void update(UserBean user) {
        String sql = "update userbean set name='" + user.getName() + "', dob='" + user.getDob() + "' where id = " + user.getId();
        jdbc.update(sql);
    }

    private Grade calculateGrade(Integer salary) {
        Grade grade;
        if (salary <= 10000) {
            grade = Grade.A3;
        } else if (salary <= 20000) {
            grade = Grade.A2;
        } else {
            grade = Grade.A1;
        }
        return grade;
    }
}
