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
import sks.project.sksbackend.dto.CompanyDto;
import sks.project.sksbackend.serviceBusiness.CompanyService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companyService; //dependency injection

	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompany(){
		
		 List<CompanyDto> company = companyService.getAllCompany();
		 
		 return ResponseEntity.ok(company);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") Long companyId){
		
		CompanyDto companyDto = companyService.getCompanyById(companyId);
		
		return ResponseEntity.ok(companyDto);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CompanyDto> updateCompany(@PathVariable("id") Long CompanyId,@RequestBody CompanyDto updateCompany){
		
		CompanyDto companyDto = companyService.updateCompany(CompanyId, updateCompany);
		
		return ResponseEntity.ok(companyDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long CompanyId){
		
		companyService.deleteCompany(CompanyId);
		
		return ResponseEntity.ok("Kullanıcı silme işlemi başarılı");
		
	}
	
	@PostMapping
	public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){
		
		CompanyDto savedCompany = companyService.createCompany(companyDto);
		
		return new ResponseEntity<>(savedCompany,HttpStatus.CREATED);
	}
	
	
	
}
