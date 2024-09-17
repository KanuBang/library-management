package com.group.library.repository.user;

import com.group.library.domain.user.User;
import com.group.library.dto.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        // 존재하지 않는 유저 업데이트 시도 예외 처리
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
        return isUserNotExist;
    }
    public boolean isUserNotExist(String name){
        String readSql = "SELECT * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        return isUserNotExist;
    }

    // 유저 등록
    public void saveUser(String name, int age){
        String sql = "INSERT INTO user(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql, name, age);
    }

    // 유저 조회
    public List<UserResponse> getUsers(){
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

    // 유저 삭제
    public void deleteUser(String name){
        String deleteSql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(deleteSql,name);
    }

    // 유저 업데이트
    public void updateUser(String name, long id){
        String updateSql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, name, id);

    }
}
