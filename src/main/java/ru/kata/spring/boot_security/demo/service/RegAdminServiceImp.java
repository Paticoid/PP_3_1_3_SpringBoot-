package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
@Service
public class RegAdminServiceImp implements RegAdminService{

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public RegAdminServiceImp(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userService.showRole("ROLE_ADMIN"));
        userService.save(user);
    }
}
