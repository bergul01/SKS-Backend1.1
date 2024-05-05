package sks.project.sksbackend.serviceBusiness;

import java.util.List;


import sks.project.sksbackend.dto.EmployeeDto;

public interface EmployeeService {
//5.olarak service business katmanı oluşturuldu interface olarak
	EmployeeDto createEmployee (EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
	void deleteEmployee(Long employeeId);
	

}
