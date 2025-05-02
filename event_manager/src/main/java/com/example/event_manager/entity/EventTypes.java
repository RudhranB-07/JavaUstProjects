package com.example.event_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "event_types")

public class EventTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "eventType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Events> eventsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Events> getEventsList() {
		return eventsList;
	}

	public void setEventsList(List<Events> eventsList) {
		this.eventsList = eventsList;
	}

	public EventTypes(Long id, String name, double price, List<Events> eventsList) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.eventsList = eventsList;
	}

	public EventTypes() {
		super();
	}
    
}
