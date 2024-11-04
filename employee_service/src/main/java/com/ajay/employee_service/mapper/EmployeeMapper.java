package com.ajay.employee_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ajay.employee_service.dto.EmployeeDto;
import com.ajay.employee_service.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);
	
	public Employee mapToEmployee(EmployeeDto dto);
	
	public EmployeeDto mapToDto(Employee employee);
}
