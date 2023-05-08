package org.atr.users.service;

import org.atr.users.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public interface UsersService {

    Optional<Users> saveUser(String name, String email, String dni, BCryptPasswordEncoder pass);

    boolean deleteUserByID(Integer id);

    Optional<Users> readUserById(Integer id);

    Optional<Users> updateUserInformation(Integer id, String name, String email, String dni, BCryptPasswordEncoder pass);

    boolean validateUserPassword(Integer id, BCryptPasswordEncoder pass);

    boolean validateUserEmail(Integer id, String email);

}
