package com.example.employee_service.dto;

public class EmployeeDto {
	
	private String EmployeeName;

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public EmployeeDto(String employeeName) {
		super();
		EmployeeName = employeeName;
	}

	public EmployeeDto() {
	}
	
	

}
