package com.example.employee_service.service;

import com.example.employee_service.entities.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Optional<Employee> findById(Integer employeeId);
    Employee updateById(Integer id, Employee employee);
    void deleteEmployee(Integer employeeId);
}
