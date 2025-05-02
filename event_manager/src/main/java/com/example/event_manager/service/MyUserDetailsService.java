package com.example.event_manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.example.event_manager.entity.UserDetails;
import com.example.event_manager.Repository.UserRepository;
import com.example.event_manager.entity.UserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private UserRepository ur;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserDetails> temp = ur.findById(email);
		UserDetails user=null;
		if(temp.isPresent()) {
			user=temp.get();
		}else {
			throw new UsernameNotFoundException("Login failed");
		}
		List<GrantedAuthority> authorities=new ArrayList<>();
		String roles = user.getRole();
		String[] arr = roles.split(",");
		for(String role:arr) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		User u=new User(user.getEmail(), user.getPassword(), authorities);
		return u;
	}
	
	public void addMyUser(UserDetails myUser) {
		//password should be encrypted
		myUser.setPassword(pe.encode(myUser.getPassword()));
		ur.save(myUser);
	}

}
