package sks.project.sksbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

	private Long id;
	private String vehicleType;
	private String driverName;
	private String driverPhone;
	private String towPlate; 
	private String trailerPlate;
}
