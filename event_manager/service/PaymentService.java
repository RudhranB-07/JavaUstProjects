package com.example.event_manager.service;

import com.example.event_manager.Repository.EventsRepository;
import com.example.event_manager.Repository.PaymentRepository;
import com.example.event_manager.entity.Events;
import com.example.event_manager.entity.Payment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EventsRepository eventsRepository;

    // Retrieve all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Retrieve a payment by ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    // Create a new payment
    public Payment createPayment(Payment payment) {
        // Validate that the event exists
        Long eventId = payment.getEvent().getId();
        Events event = eventsRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        // Set the valid event object
        payment.setEvent(event);

        // Save the payment
        return paymentRepository.save(payment);
    }

    // Update an existing payment
    @Transactional
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        // Update fields
        existingPayment.setEvent(updatedPayment.getEvent());
        existingPayment.setAmount(updatedPayment.getAmount());

        return paymentRepository.save(existingPayment);
    }

    // Delete a payment
    public boolean deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
