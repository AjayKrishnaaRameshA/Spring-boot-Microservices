package com.ajay.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String departmentCode;

}
