package com.buddhapps.globalsanghaback.service;

import com.buddhapps.globalsanghaback.model.MyUserDetails;
import com.buddhapps.globalsanghaback.model.User;
import com.buddhapps.globalsanghaback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario: " + usernameOrEmail));
        return new MyUserDetails(user);
    }


}

