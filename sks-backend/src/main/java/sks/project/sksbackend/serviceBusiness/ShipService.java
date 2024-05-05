package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.dto.ShipDto;

public interface ShipService {
	
	
	ShipDto getShipById(Long shipId); 
	
	List<ShipDto> getAllShip();
	
	ShipDto updateShip(Long shipId, ShipDto updateShip); 
	
	void deleteShip(Long shipId); 
	
	ShipDto createShip(ShipDto shipDto);
	
	

}