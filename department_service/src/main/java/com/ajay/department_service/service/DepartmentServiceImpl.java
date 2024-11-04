package com.ajay.department_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ajay.department_service.dto.DepartmentDto;
import com.ajay.department_service.mapper.DepartmentMapper;
import com.ajay.department_service.model.Department;
import com.ajay.department_service.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto dto) {
		
		Department department= DepartmentMapper.map.mapToModel(dto);
		
		Department savedDep=departmentRepository.save(department);
		
		return DepartmentMapper.map.mapToDto(savedDep);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department dep=departmentRepository.findByDepartmentCode(code);
		
		return DepartmentMapper.map.mapToDto(dep);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> dep=departmentRepository.findAll();
		return dep.stream().map((d)->DepartmentMapper.map.mapToDto(d)).collect(Collectors.toList());
	}

}
