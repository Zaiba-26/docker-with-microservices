package com.example.department_service.sevices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import com.example.department_service.repository.DeptRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptRepository deptRepository;

    // Create a new department
    @Override
    public void saveDept(Department department) {
        deptRepository.save(department);
    }

    // Get a department by ID
    @Override
    public Department getDept(Integer deptId) {
        Optional<Department> department = deptRepository.findById(deptId);
        return department.orElse(null);  // Return department or null if not found
    }

    // Get all departments
    @Override
    public List<Department> getAllDepts() {
        return deptRepository.findAll();
    }

    // Update department details
    @Override
    public void updateDept(Integer deptId, DepartmentDto deptDto) {
        Optional<Department> departmentOpt = deptRepository.findById(deptId);
        if (departmentOpt.isPresent()) {
            Department department = departmentOpt.get();
            department.setDeptName(deptDto.getDeptName());
            deptRepository.save(department);
        }
    }

    // Delete a department by ID
    @Override
    public void deleteDept(Integer deptId) {
        deptRepository.deleteById(deptId);
    }
}
