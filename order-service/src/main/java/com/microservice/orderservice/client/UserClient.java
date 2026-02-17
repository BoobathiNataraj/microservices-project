package com.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.orderservice.dto.UserDTO;

@FeignClient(
	    name = "USER-SERVICE",
	    fallback = UserClientFallback.class
	)
public interface UserClient {

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
