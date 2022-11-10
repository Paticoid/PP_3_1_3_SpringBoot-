package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> allUsers() {
         return userDao.allUsers();
    }
    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    public Role showRole(String name) {
        return userDao.showRole(name);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    @Transactional
    public void saveRole(Role role) {
        userDao.saveRole(role);
    }
    @Override
    @Transactional
    public void update(long id,User updateUser) {
        userDao.update(id,updateUser);
    }
    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
}
