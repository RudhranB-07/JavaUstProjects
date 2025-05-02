package com.example.event_manager.controller;

import com.example.event_manager.entity.Vendor;
import com.example.event_manager.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Get all vendors
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }

    // Get a vendor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id);
        return ResponseEntity.ok(vendor);
    }

    // Get vendors by service type
    @GetMapping("/serviceType/{type}")
    public ResponseEntity<List<Vendor>> getVendorsByServiceType(@PathVariable String type) {
        List<Vendor> vendors = vendorService.getVendorsByServiceType(type);
        return ResponseEntity.ok(vendors);
    }

    // Get all food vendors
    @GetMapping("/food")
    public ResponseEntity<List<Vendor>> getAllFoodVendors() {
        List<Vendor> foodVendors = vendorService.getAllfoodvendor();
        return ResponseEntity.ok(foodVendors);
    }

    // Get all music vendors
    @GetMapping("/music")
    public ResponseEntity<List<Vendor>> getAllMusicVendors() {
        List<Vendor> musicVendors = vendorService.getAllmusicvendor();
        return ResponseEntity.ok(musicVendors);
    }

    // Get all venue vendors
    @GetMapping("/venue")
    public ResponseEntity<List<Vendor>> getAllVenueVendors() {
        List<Vendor> venueVendors = vendorService.getAllvenuevendor();
        return ResponseEntity.ok(venueVendors);
    }

    // Create a new vendor
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor createdVendor = vendorService.createVendor(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
    }

    // Update an existing vendor
    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        Vendor vendor = vendorService.updateVendor(id, updatedVendor);
        return ResponseEntity.ok(vendor);
    }

    // Delete a vendor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        if (vendorService.deleteVendors(id)) {
            return ResponseEntity.ok("Vendor with id " + id + " was successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor with id " + id + " does not exist.");
        }
    }
}
