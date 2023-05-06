package org.atr.user.service.impl;

import org.atr.user.entity.User;
import org.atr.user.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> saveUser(String name, String email, String dni, BCryptPasswordEncoder pass) {
        return Optional.empty();
    }

    @Override
    public boolean deleteUserByID(Integer id) {
        return false;
    }

    @Override
    public Optional<User> readUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUserInformation(Integer id, String name, String email, String dni, BCryptPasswordEncoder pass) {
        return Optional.empty();
    }

    @Override
    public boolean validateUserPassword(Integer id, BCryptPasswordEncoder pass) {
        return false;
    }

    @Override
    public boolean validateUserEmail(Integer id, String email) {
        return false;
    }
}
