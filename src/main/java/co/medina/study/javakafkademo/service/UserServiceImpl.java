package co.medina.study.javakafkademo.service;

import co.medina.study.javakafkademo.event.UserEventProducer;
import co.medina.study.javakafkademo.model.User;
import co.medina.study.javakafkademo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEventProducer userEventProducer;

    @Override
    public User saveUser(User user) {
        log.info("Saving user {}", user);
        User savedUser = userRepository.save(user);
        userEventProducer.sendUserCreatedEvent(savedUser);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        log.info("Getting user by id {}", id);
        return userRepository.findById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        log.info("Deleting user by id {}", id);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
