package com.example.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.event.entity.Admin;
import com.example.event.entity.Guest;
import com.example.event.entity.Vendor;
import com.example.event.repository.AdminRepository;
import com.example.event.repository.GuestRepository;
import com.example.event.repository.VendorRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check Admin Repository
        Admin admin = adminRepository.findByName(username);
        if (admin != null) {
            return User.withUsername(admin.getName())
                   .password(admin.getPassword()) // Plain text password
                   .authorities(new SimpleGrantedAuthority("ADMIN")) // No ROLE_ prefix
                   .build();
        }

        // Check Guest Repository
        Guest guest = guestRepository.findByEmail(username);
        if (guest != null) {
            return User.withUsername(guest.getEmail())
                   .password(guest.getPassword())
                   .authorities(new SimpleGrantedAuthority("GUEST"))
                   .build();
        }

        // Check Vendor Repository
        Vendor vendor = vendorRepository.findByEmail(username);
        if (vendor != null) {
            return User.withUsername(vendor.getEmail())
                   .password(vendor.getPassword())
                   .authorities(new SimpleGrantedAuthority("VENDOR"))
                   .build();
        }

        // If no user is found, throw an exception
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
