package com.example.event_manager.service;

import com.example.event_manager.Repository.VendorRepository;
import com.example.event_manager.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + id));
    }

    public List<Vendor> getVendorsByServiceType(String serviceType) {
        return vendorRepository.findByServiceType(serviceType);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public  Vendor updateVendor(Long id, Vendor updatedVendor)
    {
        Vendor existingVendor=vendorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("vendor not found"));
        existingVendor.setName(updatedVendor.getName());
        existingVendor.setPrice(updatedVendor.getPrice());
        existingVendor.setServiceType(updatedVendor.getServiceType());
        return vendorRepository.save(existingVendor);
    }

    public List<Vendor> getAllfoodvendor(){
        return vendorRepository.findByServiceType("FOOD");
    }

    public List<Vendor> getAllmusicvendor(){
        return vendorRepository.findByServiceType("MUSIC");
    }
    public List<Vendor> getAllvenuevendor(){
        return vendorRepository.findByServiceType("VENUE");
    }

    public  Boolean deleteVendors(Long id)
    {
        if(vendorRepository.existsById(id))
        {
            vendorRepository.deleteById(id);
            return true;
        }
        else {
            return  false;
        }
    }
}
