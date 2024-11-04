package com.ajay.employee_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String departmentCode;
}
