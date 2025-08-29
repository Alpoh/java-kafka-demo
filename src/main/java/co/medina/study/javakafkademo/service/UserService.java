package co.medina.study.javakafkademo.service;

import co.medina.study.javakafkademo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    boolean deleteUser(Long id);
}
