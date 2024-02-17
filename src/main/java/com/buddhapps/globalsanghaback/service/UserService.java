package com.buddhapps.globalsanghaback.service;

import com.buddhapps.globalsanghaback.model.User;
import com.buddhapps.globalsanghaback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // No actualices la contraseña aquí a menos que sea intencional
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            // Más campos a actualizar...
            userRepository.save(user);
        }
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
