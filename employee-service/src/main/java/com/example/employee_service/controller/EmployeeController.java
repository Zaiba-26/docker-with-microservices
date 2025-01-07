package com.example.employee_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee_service.dto.Department;
import com.example.employee_service.dto.EmployeeDepartmentDto;
import com.example.employee_service.entities.Employee;
import com.example.employee_service.service.IEmployeeService;
import com.example.employee_service.exception.DataNotFoundException;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDeptClient deptClient;

    // Save a new employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get employee by ID
    @GetMapping("/{employeeid}")
    public ResponseEntity<EmployeeDepartmentDto> getEmployeeById(@PathVariable("employeeid") Integer employeeid) {
    	Department d = deptClient.getDept(employeeid);
    	Employee e = employeeService.findById(employeeid).get();
    	EmployeeDepartmentDto edto = new EmployeeDepartmentDto();
    	edto.setDeptId(d.getDeptId());
    	edto.setDeptName(d.getDeptName());
    	edto.setEmployeeid(e.getEmployeeid());
    	edto.setEmployeeName(e.getEmployeeName());
    	return new ResponseEntity<EmployeeDepartmentDto>(edto, HttpStatus.OK);
        /*Optional<Employee> employee = employeeService.findById(employeeid);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            throw new DataNotFoundException("Employee not found with id: " + employeeid);
        }*/
        
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateById(id, employee);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            throw new DataNotFoundException("Employee not found with id: " + id);
        }
    }

    // Delete employee by ID
    @DeleteMapping("/{employeeid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer employeeid) {
        Optional<Employee> employee = employeeService.findById(employeeid);
        if (employee.isPresent()) {
            employeeService.deleteEmployee(employeeid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new DataNotFoundException("Employee not found with id: " + employeeid);
        }
    }
}
