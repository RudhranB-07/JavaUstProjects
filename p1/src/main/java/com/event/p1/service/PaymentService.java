package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.Payment;
import com.event.p1.repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment newPaymentData) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
       if (existingPayment != null) {
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
