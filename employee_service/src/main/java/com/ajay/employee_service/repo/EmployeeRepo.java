package com.ajay.employee_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.employee_service.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
