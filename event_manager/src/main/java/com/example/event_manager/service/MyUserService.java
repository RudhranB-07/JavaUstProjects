package com.example.event_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event_manager.Repository.UserRepository;
import com.example.event_manager.entity.UserDetails;

@Service
public class MyUserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserDetails createUser(UserDetails user) {
		return userRepo.save(user);
	}

//	public UserDetails login(UserDetails user) {
//		return userRepo.
//	}

	public List<UserDetails> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	    // Get User By Email
	    public Optional<UserDetails> getUserByEmail(String email) {
	        return userRepo.findById(email);
	    }
	    
	 // Update User
	    public Optional<UserDetails> updateUser(String email, UserDetails updatedUser) {
	        return userRepo.findById(email).map(user -> {
	            user.setName(updatedUser.getName());
	            user.setPassword(updatedUser.getPassword());
	            user.setRole(updatedUser.getRole());
	            return userRepo.save(user);
	        });
	    }

	    // Delete User
	    public boolean deleteUser(String email) {
	        if (userRepo.existsById(email)) {
	            userRepo.deleteById(email);
	            return true;
	        }
	        return false;
	    }
}
