package com.example.event_manager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
