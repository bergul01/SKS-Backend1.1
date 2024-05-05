package sks.project.sksbackend.mapper;

import sks.project.sksbackend.dto.ShipDto;
import sks.project.sksbackend.entities.Ship;

public class ShipMapper {
	
	public static ShipDto mapToShipDto(Ship ship) {
		
		return new ShipDto(
				ship.getId(),
				ship.getShipName(),
				ship.getExporter(),
				ship.getDeparturePort(),
				ship.getDestinationPort()
				);
	}
	
	public static Ship mapToShip(ShipDto shipDto) {
		
		return new Ship(
				shipDto.getId(),
				shipDto.getShipName(),
				shipDto.getExporter(),
				shipDto.getDeparturePort(),
				shipDto.getDestinationPort()
				);
	}
	
}
