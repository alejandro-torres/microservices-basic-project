package org.atr.user.service;

import org.atr.user.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public interface UserService {

    Optional<User> saveUser(String name, String email, String dni, BCryptPasswordEncoder pass);

    boolean deleteUserByID(Integer id);

    Optional<User> readUserById(Integer id);

    Optional<User> updateUserInformation(Integer id, String name, String email, String dni, BCryptPasswordEncoder pass);

    boolean validateUserPassword(Integer id, BCryptPasswordEncoder pass);

    boolean validateUserEmail(Integer id, String email);

}
