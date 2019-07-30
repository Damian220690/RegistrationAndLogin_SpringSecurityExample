package com.dn.spring_security_example.service;

import com.dn.spring_security_example.model.User;
import com.dn.spring_security_example.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserDto userDto);
}
