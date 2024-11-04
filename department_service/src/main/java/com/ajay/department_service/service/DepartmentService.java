package com.ajay.department_service.service;

import java.util.List;

import com.ajay.department_service.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto dto);
	
	DepartmentDto getDepartmentByCode(String code);
	
	List<DepartmentDto> getAllDepartments();
	
}
