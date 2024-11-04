package com.ajay.department_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ajay.department_service.dto.DepartmentDto;
import com.ajay.department_service.model.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	
	DepartmentMapper map=Mappers.getMapper(DepartmentMapper.class);
	
	public DepartmentDto mapToDto(Department department);
	
	public Department mapToModel(DepartmentDto dto);
	
	

}
