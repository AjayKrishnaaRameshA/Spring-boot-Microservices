package com.ajay.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.employee_service.dto.APIResponseDto;
import com.ajay.employee_service.dto.EmployeeDto;
import com.ajay.employee_service.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
//	@GetMapping
//	public String hello() {
//		return "hi";
//	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody EmployeeDto dto){
		EmployeeDto e=service.addEmployee(dto);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
//		EmployeeDto e=service.findEmployeeById(id);
//		return new ResponseEntity<>(e, HttpStatus.OK);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long id){
		APIResponseDto e=service.findEmployeeById(id);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}
