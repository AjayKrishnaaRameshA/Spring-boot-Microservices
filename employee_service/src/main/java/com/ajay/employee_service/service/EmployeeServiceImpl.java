package com.ajay.employee_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ajay.employee_service.dto.APIResponseDto;
import com.ajay.employee_service.dto.DepartmentDto;
import com.ajay.employee_service.dto.EmployeeDto;
import com.ajay.employee_service.mapper.EmployeeMapper;
import com.ajay.employee_service.model.Employee;
import com.ajay.employee_service.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo repo;
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	/*
	 * @Autowired private WebClient webClient;
	 */
	
	@Autowired
	private FeignClientClass feignClient;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		Employee e= EmployeeMapper.mapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee=repo.save(e);
		
		return EmployeeMapper.mapper.mapToDto(savedEmployee);
	}

//	@Override
//	public EmployeeDto findEmployeeById(Long id) {
//		
//		Employee e=repo.findById(id).get();
//		
//		return EmployeeMapper.mapper.mapToDto(e);
//	}
	
	@Override
	public APIResponseDto findEmployeeById(Long id) {
		
		Employee e=repo.findById(id).get();
		
		/*
		 * Rest template
		 * 
		ResponseEntity<DepartmentDto> responseEntity =
				restTemplate.getForEntity("http://localhost:8082/department/"+e.getDepartmentCode(),
						DepartmentDto.class);
		
		DepartmentDto departmentDto = responseEntity.getBody();
		*/
		
		
		/*
		 * webclient
		 * 
		 * DepartmentDto departmentDto=webClient. get().
		 * uri("http://localhost:8082/department/"+e.getDepartmentCode()). retrieve().
		 * bodyToMono(DepartmentDto.class). block();
		 */
		
		DepartmentDto departmentDto= feignClient.getDepartment(e.getDepartmentCode());
		
		EmployeeDto employeeDto= EmployeeMapper.mapper.mapToDto(e);
		
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);

		return apiResponseDto;
		
		
	}
	
}
