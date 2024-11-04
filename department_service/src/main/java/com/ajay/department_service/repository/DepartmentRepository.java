package com.ajay.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.department_service.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentCode(String code);
}
