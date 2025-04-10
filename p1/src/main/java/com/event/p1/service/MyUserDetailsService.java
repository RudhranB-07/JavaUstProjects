package com.event.p1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.event.p1.entity.MyUser;
import com.event.p1.repository.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private MyUserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> temp = ur.findById(username);
		MyUser user=null;
		if(temp.isPresent()) {
			user=temp.get();
		}else {
			throw new UsernameNotFoundException("Login failed");
		}
		List<GrantedAuthority> authorities=new ArrayList<>();
		String roles = user.getRoles();
		String[] arr = roles.split(",");
		for(String role:arr) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		User u=new User(user.getUsername(), user.getPassword(), authorities);
		return u;
	}
	
	public void addMyUser(MyUser myUser) {
		//password should be encrypted
		myUser.setPassword(pe.encode(myUser.getPassword()));
		ur.save(myUser);
	}

}
