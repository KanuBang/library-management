package com.group.library.service.user;

import com.group.library.dto.response.UserResponse;
import com.group.library.dto.user.UserCreateRequest;
import com.group.library.dto.user.UserUpdateRequest;
import com.group.library.repository.user.UserJdbcRepository;

import java.util.List;
//@Service
public class UserService1 {
    private final UserJdbcRepository userRepository;
    public UserService1(UserJdbcRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 등록
    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(),request.getAge());
    }

    // 유저 조회
    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

    // 유저 삭제
    public void deleteUser(String name){
        // 존재하지 않는 유저 업데이트 시도 예외 처리
        boolean isUserNotExist = userRepository.isUserNotExist(name);
        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

    // 유저 업데이트
    public void updateUser(UserUpdateRequest request) {
        boolean isUserNotExist = userRepository.isUserNotExist(request.getId());
        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUser(request.getName(),request.getId());
    }
}
