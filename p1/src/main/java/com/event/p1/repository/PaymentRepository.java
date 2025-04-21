package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.p1.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
