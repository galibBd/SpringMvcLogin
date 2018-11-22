package com.idb.service;

import com.idb.model.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppServiceImp implements AppService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Users users) {
        String sql = "insert into Users (name,password,email) value(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{users.getName(), users.getPassword(), users.getEmail()});
    }

    @Override
    public List<Users> checkUser(String name, String password) {
        Users users = new Users();
        String sql = "select name, password from Users where name='" +name + "' and password = '"+password+"'";
        List user = jdbcTemplate.queryForList(sql);
       return user;       
    }

    @Override
    public List<Users> grtAll() {
        String sql = "select name,password,email from users";
        List user = jdbcTemplate.queryForList(sql);
        return user;
    }

    //    public static void main(String[] args) {
//        new AppServiceImp().add(new Users("a","aa","aaa"));
//    }
}
