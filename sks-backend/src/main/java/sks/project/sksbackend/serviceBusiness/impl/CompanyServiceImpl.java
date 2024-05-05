package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.CompanyDto;
import sks.project.sksbackend.entities.Company;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.mapper.CompanyMapper;
import sks.project.sksbackend.repositoryDataAccess.CompanyRepository;
import sks.project.sksbackend.serviceBusiness.CompanyService;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository; //dependency injection

	@Override
	public List<CompanyDto> getAllCompany() {
		
		List<Company> companies = companyRepository.findAll();
		
		return companies.stream().map((company) -> CompanyMapper.mapToCompanyDto(company)).collect(Collectors.toList());
	}

	@Override
	public CompanyDto getCompanyById(Long companyId) {
		
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mevcut değil" + companyId));
		
		return CompanyMapper.mapToCompanyDto(company);
	}

	@Override
	public CompanyDto updateCompany(Long CompanyId, CompanyDto updateCompany) {
		
		Company company = companyRepository.findById(CompanyId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mevcut değil" + CompanyId));
		
		company.setCompanyName(updateCompany.getCompanyName());
		company.setPhoneNumber(updateCompany.getPhoneNumber());
		company.setEmail(updateCompany.getEmail());
		company.setTaxOffice(updateCompany.getTaxOffice());
		company.setTaxNumber(updateCompany.getTaxNumber());
		company.setAddress(updateCompany.getAddress());
		
		Company newCompany = companyRepository.save(company);
		
		return CompanyMapper.mapToCompanyDto(newCompany);
	}

	@Override
	public void deleteCompany(Long CompanyId) {
		
		Company company = companyRepository.findById(CompanyId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mavcut değil" + CompanyId));
		
		companyRepository.deleteById(CompanyId);
		
		
	}

	@Override
	public CompanyDto createCompany(CompanyDto companyDto) {
		
		Company company = CompanyMapper.mapToCompany(companyDto);
		
		Company savedCompany = companyRepository.save(company);
		
		return CompanyMapper.mapToCompanyDto(savedCompany);
	}

}
