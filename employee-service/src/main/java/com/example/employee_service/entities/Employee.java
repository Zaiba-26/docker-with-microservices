package com.example.employee_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employeeid;
	@Column(nullable = false)
	private String EmployeeName;
	@Column(nullable = false,unique = true)
	private String EmployeeEmail;
	public int getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	public Employee(int employeeid, String employeeName, String employeeEmail) {
		super();
		Employeeid = employeeid;
		EmployeeName = employeeName;
		EmployeeEmail = employeeEmail;
	}
	public Employee() {
        // Default constructor needed by Hibernate
    }
	
	

}
