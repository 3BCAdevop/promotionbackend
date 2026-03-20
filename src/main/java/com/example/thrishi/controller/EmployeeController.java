package com.example.thrishi.controller;

import com.example.thrishi.entity.Employee;
import com.example.thrishi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ✅ FIXED CORS (your real frontend URL)
@CrossOrigin(origins = "https://promotionfrontend-cvfcdacxhbeqczd9.southeastasia-01.azurewebsites.net")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ===== GET ALL =====
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    // ===== CREATE =====
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }

    // ===== UPDATE =====
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }
}
