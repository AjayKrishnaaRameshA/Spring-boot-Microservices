package com.ajay.department_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.department_service.dto.DepartmentDto;
import com.ajay.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("department")
public class DepartmentController {

	private DepartmentService service;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") String depId) {
		DepartmentDto dto=service.getDepartmentByCode(depId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@PostMapping("/new")
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto dto){
		DepartmentDto savedDto=service.saveDepartment(dto);
		return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
		
	}
}
