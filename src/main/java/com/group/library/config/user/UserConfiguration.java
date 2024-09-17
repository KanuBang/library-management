package com.group.library.config.user;

import com.group.library.domain.user.UserRepository;
import com.group.library.repository.user.UserJdbcRepository;
import com.group.library.service.user.UserService1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserConfiguration {
    @Bean
    public UserService1 userService(UserJdbcRepository userRepository){
        return new UserService1(userRepository);
    }
}
