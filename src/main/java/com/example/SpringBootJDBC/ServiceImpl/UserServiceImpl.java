package com.example.SpringBootJDBC.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.SpringBootJDBC.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Integer id,String name, Integer age) {
        jdbcTemplate.update("insert into users(id,name, age) values(?,?, ?)", id, name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from users where name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}