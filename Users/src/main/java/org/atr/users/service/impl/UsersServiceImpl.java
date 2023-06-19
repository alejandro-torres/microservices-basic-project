package org.atr.users.service.impl;

import org.atr.users.entity.Users;
import org.atr.users.service.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public Optional<Users> saveUser(String name, String email, String dni, BCryptPasswordEncoder pass) {
        return Optional.empty();
    }

    @Override
    public boolean deleteUserByID(Integer id) {
        return false;
    }

    @Override
    public Optional<Users> readUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Users> updateUserInformation(Integer id, String name, String email, String dni, BCryptPasswordEncoder pass) {
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
