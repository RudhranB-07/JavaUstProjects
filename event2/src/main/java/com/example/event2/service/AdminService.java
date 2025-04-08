package com.example.event2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event2.entity.Admin;
import com.example.event2.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // Fetch all admins
    public List<Admin> getAllData() {
        return adminRepository.findAll();
    }

    // Add an admin manually (Optional)
    public Admin addAdmin(Admin data) {
        return adminRepository.save(data);
    }

    // Get admin name by ID
    public Optional<String> getName(Long id) {
        return adminRepository.findById(id).map(Admin::getName);
    }

 // **Update Admin**
    public Optional<Admin> updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(updatedAdmin.getName());
            admin.setPassword(updatedAdmin.getPassword());
            return adminRepository.save(admin);
        });
    }

    // **Delete Admin**
    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // **Register a new admin**
    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin); // Stores admin in the database for login
    }

    // **Login: Validate username & password**
    public Optional<Admin> login(String name, String password) {
        return adminRepository.findByName(name)
                .filter(admin -> admin.getPassword().equals(password)); // Basic login check
    }
}

