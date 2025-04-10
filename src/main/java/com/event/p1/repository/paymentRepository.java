package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.p1.entity.payment;

public interface paymentRepository extends JpaRepository<payment, Long> {

}
