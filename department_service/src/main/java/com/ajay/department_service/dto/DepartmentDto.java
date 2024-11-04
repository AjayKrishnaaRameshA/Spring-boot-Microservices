package com.ajay.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {

	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
