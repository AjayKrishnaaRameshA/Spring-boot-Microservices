package com.ajay.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ajay.employee_service.dto.DepartmentDto;

/*@FeignClient(url="http://localhost:8082/department/",name = "department-service")
 * */

@FeignClient(name="DEP-SERVICE")// for spring cloud netflix load balancer
public interface FeignClientClass {

	@GetMapping("/department/{id}")
	public DepartmentDto getDepartment(@PathVariable("id") String depId);
}
