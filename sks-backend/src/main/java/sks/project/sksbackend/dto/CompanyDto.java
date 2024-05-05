package sks.project.sksbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	private Long id;
	private String companyName;
	private String phoneNumber;
	private String email;
	private String taxOffice;
	private String taxNumber;
	private String address;
	
	
	
}