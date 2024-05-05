package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.EmployeeDto;
import sks.project.sksbackend.entities.Employee;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.mapper.EmployeeMapper;
import sks.project.sksbackend.repositoryDataAccess.EmployeeRepository;
import sks.project.sksbackend.serviceBusiness.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
//6.olarak service business katmanı içerisinde EmployeeService sınıfı oluşturuldu
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto); //employeeDto'yu employee'ye dönüştürdüm
		
		Employee savedEmployee = employeeRepository.save(employee); // dönüştürdüğüm employee'yi save metodu ile veritabanına ekler
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee); // kaydedilen employee'yi employeeDto ya dönüştürür
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
/* employeeRepository kullanılarak "findById" metodu çağrılır."employeeId"ye karşılık gelen bir çalışanı veritabanından alır.
eğer bu "employeeId"ye sahip bir çalışan bulunamazsa "orElseThrow" metodu kullanılarak bir exception oluşturulur ve ilgili 
mesajla birlikte fırlatılır.*/
		Employee employee =	employeeRepository.findById(employeeId)
			.orElseThrow(() ->
				new ResourceNotFoundException("Employee is not exists with given id :" + employeeId));
		
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
				);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updateEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
		);
		
		employeeRepository.deleteById(employeeId);
	}

}
