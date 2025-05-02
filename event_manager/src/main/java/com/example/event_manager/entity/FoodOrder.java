package com.example.event_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_order")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_type_id", nullable = false)
    private FoodType foodType;

    private long quantity;
    private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FoodOrder(Long id, FoodType foodType, long quantity, double price) {
		super();
		this.id = id;
		this.foodType = foodType;
		this.quantity = quantity;
		this.price = price;
	}
	public FoodOrder() {
		super();
	}
}
