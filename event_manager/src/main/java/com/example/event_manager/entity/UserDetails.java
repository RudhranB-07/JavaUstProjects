package com.example.event_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_details")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDetails {

    @Id
    private String email;

    private String name;
    private String password;
    private String role;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Events> events;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public UserDetails(String email, String name, String password, String role, List<Events> events) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.events = events;
	}

	public UserDetails() {
		super();
	}
}
