package com.example.employee_service.dto;

public class EmployeeDepartmentDto {
	private int Employeeid;
	private String EmployeeName;
	private int deptId;
	private String deptName;
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
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
//	public EmployeeDepartmentDto(int employeeid, String employeeName, int deptId, String deptName) {
//		super();
//		Employeeid = employeeid;
//		EmployeeName = employeeName;
//		this.deptId = deptId;
//		this.deptName = deptName;
//	}
//	public EmployeeDepartmentDto() {
//		super();
//	}
	

}
