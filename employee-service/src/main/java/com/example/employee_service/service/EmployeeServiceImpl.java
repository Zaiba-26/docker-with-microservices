package com.example.employee_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_service.entities.Employee;
import com.example.employee_service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(Integer employeeid) {
		return employeeRepository.findById(employeeid);
	}

	@Override
	public void deleteEmployee(Integer employeeid) {
		 employeeRepository.findById(employeeid);		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateById(Integer id, Employee employee) {
     Employee emp=employeeRepository.findById(id).get();
     if(emp!=null)
     {
    	 emp.setEmployeeName(employee.getEmployeeName());
    	 emp.setEmployeeEmail(employee.getEmployeeEmail());
    	 return employeeRepository.save(emp);	 
     }
     return null;
	}
}