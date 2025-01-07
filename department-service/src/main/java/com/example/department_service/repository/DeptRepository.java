package com.example.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.department_service.entity.Department;


public interface DeptRepository extends JpaRepository<Department, Integer> {

}
