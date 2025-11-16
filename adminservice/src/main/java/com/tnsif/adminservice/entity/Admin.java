package com.tnsif.adminservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminName;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private LocalDate createdDate;
    private String department;

    // Constructors
    public Admin() {}

    public Admin(String adminName, String email, String password, String role, String phoneNumber, LocalDate createdDate, String department) {
        this.adminName = adminName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}