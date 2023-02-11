package com.example.garage_v2.service;

import com.example.garage_v2.model.Auth;
import com.example.garage_v2.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.getAuthByName(username);
        if (auth == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found!");
        }
        return new CustomUserDetails(auth);
    }
}
