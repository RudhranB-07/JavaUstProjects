package com.example.event2.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event2.entity.Admin;
import com.example.event2.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // Test API
    @GetMapping("/hello")
    public String greet() {
        return "Hello! Admin...";
    }

    // Fetch all admins
    @GetMapping("/all")
    public List<Admin> getAllData() {
        return adminService.getAllData();
    }

    // Get admin name by ID
    @GetMapping("/name/{id}")
    public Optional<String> getName(@PathVariable Long id) {
        return adminService.getName(id);
    }
   
 // **Update Admin (PUT)**
    @PutMapping("/update/{id}")
    public Optional<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        return adminService.updateAdmin(id, updatedAdmin);
    }

    // **Delete Admin (DELETE)**
    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id) ? "Admin deleted successfully" : "Admin not found";
    }


    // **Register a new Admin**
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin); // Store admin for future login
    }

    // **Login API (Checks username & password)**
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        Optional<Admin> existingAdmin = adminService.login(admin.getName(), admin.getPassword());
        return existingAdmin.isPresent() ? "Login Successful for " + admin.getName(): "Invalid Credentials";
    }
}


//	 @PostMapping("/register")
//	    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
//	        return ResponseEntity.ok(adminService.saveAdmin(admin));
//	    }
//
//	    @GetMapping("/{name}")
//	    public ResponseEntity<Admin> getAdminByName(@PathVariable String name) {
//	        return ResponseEntity.ok(adminService.findAdminByName(name));
//	    }
	
//	@GetMapping("/name/{id}")
//    public Optional<String> getMovieNameById(@PathVariable Long id) {
//        return mService.getMovieNameById(id);
//    }
//	
//	@PostMapping("/add")
//    public MEntity addMovie(@RequestBody MEntity movie) {
//        return mService.addMovie(movie);
//    }
//
//    //  Get all movies
//    @GetMapping("/all")
//    public List<MEntity> getAllMovies() {
//        return mService.getAllMovies();
//    }

