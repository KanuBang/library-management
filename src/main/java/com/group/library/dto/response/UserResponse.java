package com.group.library.dto.response;
import com.group.library.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private long id;
    private String name;
    private Integer age;
}
