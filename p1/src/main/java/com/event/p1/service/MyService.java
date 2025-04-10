package com.event.p1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.p1.entity.MyUser;
import com.event.p1.repository.MyUserRepository;

@Service
public class MyService {

	@Autowired
	private MyUserRepository myrepo;
	
	public List<MyUser> getAll(){
		return myrepo.findAll();
	}
}
