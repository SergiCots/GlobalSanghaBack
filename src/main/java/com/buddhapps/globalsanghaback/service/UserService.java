package com.buddhapps.globalsanghaback.service;

import com.buddhapps.globalsanghaback.model.User;
import com.buddhapps.globalsanghaback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Métodos existentes...

    public User login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return userRepository.findByEmail(email);
        // Nota: Este método presupone que tienes un método `findByEmail` en tu `UserRepository`.
    }

    public User createUser(User user) {
        // Codifica la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Extrae el nombre de usuario del email
        String username = user.getEmail().substring(0, user.getEmail().indexOf("@"));
        user.setUsername(username);

        // Guarda el usuario en la base de datos
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
