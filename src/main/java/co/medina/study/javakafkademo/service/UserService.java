package co.medina.study.javakafkademo.service;

import co.medina.study.javakafkademo.event.UserEventProducer;
import co.medina.study.javakafkademo.model.User;
import co.medina.study.javakafkademo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserEventProducer userEventProducer;

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        userEventProducer.sendUserCreatedEvent(savedUser);
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
