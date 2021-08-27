package com.example.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserBean> {

    @Override
    public UserBean mapRow(ResultSet rs, int i) throws SQLException {
        UserBean user = new UserBean();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setDob(rs.getDate("dob"));
        user.setSalary(rs.getInt("salary"));
        user.setGrade(rs.getString("grade"));
        return user;
    }

}
