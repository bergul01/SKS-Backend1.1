package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.ShipDto;
import sks.project.sksbackend.entities.Ship;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.mapper.ShipMapper;
import sks.project.sksbackend.repositoryDataAccess.ShipRepository;
import sks.project.sksbackend.serviceBusiness.ShipService;


@Service
@AllArgsConstructor
public class ShipServiceImpl implements ShipService{
	
	private ShipRepository shipRepository;

	@Override
	public ShipDto getShipById(Long shipId) {
		
		Ship ship = shipRepository.findById(shipId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil" + shipId));
			
			return ShipMapper.mapToShipDto(ship);
		
		
	}

	@Override
	public List<ShipDto> getAllShip() {

		List<Ship> ships = shipRepository.findAll();
		
		return ships.stream().map((ship) -> ShipMapper.mapToShipDto(ship)).collect(Collectors.toList());
	}

	@Override
	public ShipDto updateShip(Long shipId, ShipDto updateShip) {
	
		Ship ship = shipRepository.findById(shipId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil" + shipId));
		
		ship.setShipName(updateShip.getShipName());
		ship.setExporter(updateShip.getExporter());
		ship.setDeparturePort(updateShip.getDeparturePort());
		ship.setDestinationPort(updateShip.getDestinationPort());
		
		Ship newShip = shipRepository.save(ship);
		
		
		return ShipMapper.mapToShipDto(newShip);
		
	}

	@Override
	public void deleteShip(Long shipId) {
		
		Ship ship = shipRepository.findById(shipId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil" + shipId));
		
		shipRepository.deleteById(shipId);
		
		
	}

	@Override
	public ShipDto createShip(ShipDto shipDto) {
		
		Ship ship = ShipMapper.mapToShip(shipDto);
		
		Ship savedShip = shipRepository.save(ship);
		
		return ShipMapper.mapToShipDto(savedShip);
	}
	
	

}