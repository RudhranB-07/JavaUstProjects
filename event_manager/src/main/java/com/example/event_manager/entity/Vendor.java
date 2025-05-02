package com.example.event_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vendors")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String serviceType;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Events> locations;

    @OneToMany(mappedBy = "music", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Events> musicVendors;

    @OneToMany(mappedBy = "foodVendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Events> foodVendors;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public List<Events> getLocations() {
		return locations;
	}

	public void setLocations(List<Events> locations) {
		this.locations = locations;
	}

	public List<Events> getMusicVendors() {
		return musicVendors;
	}

	public void setMusicVendors(List<Events> musicVendors) {
		this.musicVendors = musicVendors;
	}

	public List<Events> getFoodVendors() {
		return foodVendors;
	}

	public void setFoodVendors(List<Events> foodVendors) {
		this.foodVendors = foodVendors;
	}

	public Vendor(Long id, String name, Double price, String serviceType, List<Events> locations,
			List<Events> musicVendors, List<Events> foodVendors) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.serviceType = serviceType;
		this.locations = locations;
		this.musicVendors = musicVendors;
		this.foodVendors = foodVendors;
	}

	public Vendor() {
		super();
	}
	
}
