package com.microservice.orderservice.client;

import com.microservice.orderservice.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO user = new UserDTO();
        user.setUserId(id);
        user.setName("USER SERVICE DOWN");
        user.setEmail("N/A");
        return user;
    }
}
