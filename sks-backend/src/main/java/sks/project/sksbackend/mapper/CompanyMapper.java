package sks.project.sksbackend.mapper;

import sks.project.sksbackend.dto.CompanyDto;
import sks.project.sksbackend.entities.Company;

public class CompanyMapper {

	public static CompanyDto mapToCompanyDto(Company company) {
		
		return new CompanyDto(
				company.getId(),
				company.getCompanyName(),
				company.getPhoneNumber(),
				company.getEmail(),
				company.getTaxOffice(),
				company.getTaxNumber(),
				company.getAddress()
				);	
	}
	
	public static Company mapToCompany(CompanyDto companyDto) {
		
		return new Company(
				companyDto.getId(),
				companyDto.getCompanyName(),
				companyDto.getPhoneNumber(),
				companyDto.getEmail(),
				companyDto.getTaxOffice(),
				companyDto.getTaxNumber(),
				companyDto.getAddress()
				);
		
	}
	
}
