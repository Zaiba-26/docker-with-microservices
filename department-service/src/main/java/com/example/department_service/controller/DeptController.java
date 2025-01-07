package com.example.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import com.example.department_service.sevices.IDeptService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    // POST: Create a new department
    @PostMapping("/create")
    public ResponseEntity<String> saveDept(@RequestBody Department dept) {
        deptService.saveDept(dept);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department saved successfully");
    }

    // GET: Get a department by ID
    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDept(@PathVariable Integer deptId) {
        Department department = deptService.getDept(deptId);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GET: Get all departments
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepts() {
        List<Department> departments = deptService.getAllDepts();
        return ResponseEntity.ok(departments);
    }

    // PUT: Update a department by ID
    @PutMapping("/update/{deptId}")
    public ResponseEntity<String> updateDept(@PathVariable Integer deptId, @RequestBody DepartmentDto deptDto) {
        deptService.updateDept(deptId, deptDto);
        return ResponseEntity.status(HttpStatus.OK).body("Department updated successfully");
    }

    // DELETE: Delete a department by ID
    @DeleteMapping("/delete/{deptId}")
    public ResponseEntity<String> deleteDept(@PathVariable Integer deptId) {
        deptService.deleteDept(deptId);
        return ResponseEntity.status(HttpStatus.OK).body("Department deleted successfully");
    }
}
