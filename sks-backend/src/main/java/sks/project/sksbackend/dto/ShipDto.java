package sks.project.sksbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipDto {

	private Long id;
	private String shipName;
	private String exporter;
	private String departurePort;
	private String destinationPort;
}

