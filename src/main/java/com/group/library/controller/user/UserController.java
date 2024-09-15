package com.group.library.controller.user;

import com.group.library.dto.response.UserResponse;
import com.group.library.dto.user.UserCreateRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.group.library.domain.user.User;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<User> users = new ArrayList<>();

    // 유저 등록
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.getName(),request.getAge()));
    }

    // 유저 조회
    @GetMapping("/user")
    public List<UserResponse> findUser() {

        List<UserResponse> responses = new ArrayList<>();

        for(int i = 0; i < users.size(); i++){
            responses.add(new UserResponse(i+1, users.get(i)));
        }

        return  responses;
    }
}
