package com.group.library.service.user;

import com.group.library.domain.user.User;
import com.group.library.domain.user.UserRepository;
import com.group.library.dto.response.UserResponse;
import com.group.library.dto.user.UserCreateRequest;
import com.group.library.dto.user.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService2 {
    private final UserRepository userRepository;

    public UserService2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 저장
    public void saveUser(UserCreateRequest request){
        User user = userRepository.save(new User(request.getName(), request.getAge()));
        System.out.println(user.getId());
    }

    // 회원 목록
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    // 회원 수정
    public void updateUser(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getId()).orElseThrow(IllegalAccessError::new);
        user.updateName(userUpdateRequest.getName());
        userRepository.save(user);
    }

    // 회원 삭제
    @Transactional
    public void deleteUser(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isEmpty()) {
            throw new IllegalArgumentException();
        }
        userRepository.delete(user.get());
    }

    // 회원 나이 범위
    public List<User> findUserByAgeRange(int startAge, int endAge){
         return userRepository.findAllByAgeBetween(startAge, endAge);
    }
}
