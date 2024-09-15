package com.group.library.controller.user;

import com.group.library.dto.response.UserResponse;
import com.group.library.dto.user.UserCreateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.group.library.domain.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 유저 등록
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    // 유저 조회
    @GetMapping("/user")
    public List<UserResponse> findUser() {

        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            // RowMapper 인터페이스를 사용해 각 행(row)을 UserResponse 객체로 매핑합니다.
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                User user = new User(rs.getString("name"), rs.getInt("age"));
                return new UserResponse(id, user);
            }
        });
    }
}
