package com.example.department_service.sevices;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;

import java.util.List;

public interface IDeptService {
    void saveDept(Department department);  // Create
    Department getDept(Integer deptId);    // Read (single)
    List<Department> getAllDepts();        // Read (all)
    void updateDept(Integer deptId, DepartmentDto deptDto);  // Update
    void deleteDept(Integer deptId);       // Delete
}
