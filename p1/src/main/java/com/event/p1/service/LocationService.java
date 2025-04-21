package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.Location;
import com.event.p1.repository.LocationRepository;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location newLocationData) {
        Location existingLocation = locationRepository.findById(id).orElse(null);
        if (existingLocation != null) {
            existingLocation.setName(newLocationData.getName());
            existingLocation.setPrice(newLocationData.getPrice());
            return locationRepository.save(existingLocation);
        }
        return null;
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
