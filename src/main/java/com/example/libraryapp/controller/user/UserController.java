package com.example.libraryapp.controller.user;

import com.example.libraryapp.domain.user.Fruit;
import com.example.libraryapp.domain.user.User;
import com.example.libraryapp.dto.user.request.UserCreateRequest;
import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //jdbc - java db connecter
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")//post/user
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user(name,age) VALUES (?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());

    }


    //mapRow안에서 SQL의 실행 결과가 나오면 그 결과들에 있는 데이터를 가져와서 user response로 바꿔줌
    //RowMapper는 쿼리의 결과를 받아, 객체를 반환
    //모든 유저 정보를 하나씩 하나씩 user response로 바꿔서 리턴
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        //id를 기준으로 유저가 존재하는지 확인하기 위해 SELECT 쿼리 작성
        String readSql = "SELECT * FROM user WHERE id =?";
        //SQL을 날려 DB에 데이터가 있는지 확인
        //readSql에 있던 ?자리에 request.getId()가 들어감
        //만약 SELECT SQL의 결과가 있으면 0으로 변환
        //query는 반화된 값들을 리스트로 감싸줌
        //해당 아이디를 가진 유저가 없다면 빈리스트가 나옴
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        //유저가 존재하지 않는다면 IllegalArgumentException을 던짐
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }
        String updateSql = "UPDATE user SET name =?WHERE id = ?";
        jdbcTemplate.update(updateSql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String readSql = "SELECT * FROM user WHERE name =?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    @GetMapping("/user/error-test")
    public void errorTest() {
        throw new IllegalArgumentException();
    }
}
