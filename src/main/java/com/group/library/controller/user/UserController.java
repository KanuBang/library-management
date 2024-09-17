package com.group.library.controller.user;

import com.group.library.dto.response.UserResponse;
import com.group.library.dto.user.UserCreateRequest;
import com.group.library.dto.user.UserUpdateRequest;
import com.group.library.service.fruit.FruitService;
import com.group.library.service.user.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;
import com.group.library.domain.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final FruitService fruitService;
    private final FruitService fruitService1;
    public UserController(UserService userService,
                          @Qualifier("appleService") FruitService fruitService,
                          @Qualifier("main") FruitService fruitService1
    ) {

        this.userService = userService;
        this.fruitService = fruitService;
        this.fruitService1 = fruitService1;
        System.out.println(fruitService.toString());
        System.out.println(fruitService1.toString());

    }

    // 유저 등록
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    // 유저 조회
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    // 유저 삭제
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

    // 유저 업데이트
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    // 예외 발생 테스트
    @GetMapping("/user/error-test")
    public void errorTest(){
        throw new IllegalArgumentException();
    }
}
