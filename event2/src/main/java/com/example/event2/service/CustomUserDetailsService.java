package com.example.event2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.event2.entity.Admin;
import com.example.event2.repository.AdminRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));

        return User.withUsername(admin.getName())
                   .password(admin.getPassword()) // No password encoding for testing
                   .authorities(new SimpleGrantedAuthority("ADMIN"))
                   .build();
    }
}
