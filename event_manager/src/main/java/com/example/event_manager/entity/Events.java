package com.example.event_manager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "events")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eventType_id", nullable = false)
    private EventTypes eventType;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
    private UserDetails userDetails;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "locationvendor_id", nullable = false)
    private Vendor location;

    @ManyToOne
    @JoinColumn(name = "musicvendor_id", nullable = false)
    private Vendor music;

    @ManyToOne
    @JoinColumn(name = "foodorder_id", nullable = false)
    private FoodOrder foodOrder;

    @ManyToOne
    @JoinColumn(name = "foodvendor_id", nullable = false)
    private Vendor foodVendor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventTypes getEventType() {
		return eventType;
	}

	public void setEventType(EventTypes eventType) {
		this.eventType = eventType;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vendor getLocation() {
		return location;
	}

	public void setLocation(Vendor location) {
		this.location = location;
	}

	public Vendor getMusic() {
		return music;
	}

	public void setMusic(Vendor music) {
		this.music = music;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public Vendor getFoodVendor() {
		return foodVendor;
	}

	public void setFoodVendor(Vendor foodVendor) {
		this.foodVendor = foodVendor;
	}

	public Events(Long id, EventTypes eventType, UserDetails userDetails, Date date, Vendor location, Vendor music,
			FoodOrder foodOrder, Vendor foodVendor) {
		this.id = id;
		this.eventType = eventType;
		this.userDetails = userDetails;
		this.date = date;
		this.location = location;
		this.music = music;
		this.foodOrder = foodOrder;
		this.foodVendor = foodVendor;
	}

	public Events() {
	}


}
