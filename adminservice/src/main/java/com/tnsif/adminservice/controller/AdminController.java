package com.tnsif.adminservice.controller;

import com.tnsif.adminservice.entity.Admin;
import com.tnsif.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:4200") // allows frontend to connect easily
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ✅ Get all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // ✅ Get admin by ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // ✅ Add new admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    // ✅ Update existing admin
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Optional<Admin> existing = adminService.getAdminById(id);
        if (existing.isPresent()) {
            Admin admin = existing.get();
            admin.setAdminName(updatedAdmin.getAdminName());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setPassword(updatedAdmin.getPassword());
            admin.setRole(updatedAdmin.getRole());
            admin.setPhoneNumber(updatedAdmin.getPhoneNumber());
            admin.setCreatedDate(updatedAdmin.getCreatedDate());
            admin.setDepartment(updatedAdmin.getDepartment());
            return adminService.saveAdmin(admin);
        } else {
            return null;
        }
    }

    // ✅ Delete admin
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin with ID " + id + " deleted successfully.";
    }
}