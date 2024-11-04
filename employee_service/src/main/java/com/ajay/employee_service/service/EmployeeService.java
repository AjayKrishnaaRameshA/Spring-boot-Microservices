package com.ajay.employee_service.service;

import com.ajay.employee_service.dto.APIResponseDto;
import com.ajay.employee_service.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	//EmployeeDto findEmployeeById(Long id);
	
	APIResponseDto findEmployeeById(Long id);
}
