package sks.project.sksbackend.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.EmployeeDto;
import sks.project.sksbackend.serviceBusiness.EmployeeService;


@CrossOrigin("*") //tüm kaynakların tüm kaynaklardan istek almasına izin verir anlamına gelir. react tarafında bu olmadığında sıkıntı çekiyoruz.
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
//7.olarak controller katmanı oluşturuldu.
	private EmployeeService employeeService;
	
	
	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		//http://localhost:8080/api/employees
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}

	
	//Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
	//http://localhost:8080/api/employees/2
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		
		return ResponseEntity.ok(employeeDto);
		
	}
	
	//Build Get All Employee REST API
	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		//http://localhost:8080/api/employees
		
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	} 	
	
	
	// Build Update REST API
	@PutMapping("{id}") //seçilen id kısmındaki değişkenleri değiştirdik
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
													@RequestBody EmployeeDto updatedEmployee){
		//http://localhost:8080/api/employees/1
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	// Build Delete Employee REST API 
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		//http://localhost:8080/api/employees/1
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!.");
	}
	
	
	
	
}
