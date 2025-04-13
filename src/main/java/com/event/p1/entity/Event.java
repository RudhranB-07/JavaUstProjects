package com.event.p1.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Event")

public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long event_type_id;
    private String user_email;
    private LocalDate date;
   

//    public class Main {
//        public static void main(String[] args) {
//            // Directly setting a date
//            LocalDate date = LocalDate.of(2978, 10, 10);
//            
//            System.out.println("Date: " + date);
//        }
//    }

    private Long location_id;
    private Long music_id;
    private Long food_id;
    private Long vendor_id;
    private Long payment_id;
    @ManyToOne
    @JoinColumn(name = "event_type_id") // Links to EventType
    private EventType eventType;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEvent_type_id() {
		return event_type_id;
	}
	public void setEvent_type_id(Long event_type_id) {
		this.event_type_id = event_type_id;
	}
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	public Long getMusic_id() {
		return music_id;
	}
	public void setMusic_id(Long music_id) {
		this.music_id = music_id;
	}
	public Long getFood_id() {
		return food_id;
	}
	public void setFood_id(Long food_id) {
		this.food_id = food_id;
	}
	public Long getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(Long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public Long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}
	


}
