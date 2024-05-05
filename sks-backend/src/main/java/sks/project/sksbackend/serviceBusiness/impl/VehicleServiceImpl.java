package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.VehicleDto;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.mapper.VehicleMapper;
import sks.project.sksbackend.repositoryDataAccess.VehicleRepository;
import sks.project.sksbackend.serviceBusiness.VehicleService;


@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{
	
	private VehicleRepository vehicleRepository;

	@Override
	public VehicleDto getVehicleById(Long vehicleId) {
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
			.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil" + vehicleId));
		
		return VehicleMapper.mapToVehicleDto(vehicle);
	}

	@Override
	public List<VehicleDto> getAllVehicle() {
		
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		return vehicles.stream().map((vehicle) -> VehicleMapper.mapToVehicleDto(vehicle)).collect(Collectors.toList());
	}

	@Override
	public VehicleDto updateVehicle(Long vehicleId, VehicleDto updateVehicle) {
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil" + vehicleId));
		
		vehicle.setVehicleType(updateVehicle.getVehicleType());
		vehicle.setDriverName(updateVehicle.getDriverName());
		vehicle.setDriverPhone(updateVehicle.getDriverPhone());
		vehicle.setTowPlate(updateVehicle.getTowPlate());
		vehicle.setTrailerPlate(updateVehicle.getTrailerPlate());
		
		Vehicle newVehicle = vehicleRepository.save(vehicle);
		
		
		return VehicleMapper.mapToVehicleDto(newVehicle);
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil" + vehicleId));
		
		vehicleRepository.deleteById(vehicleId);
		
	}

	@Override
	public VehicleDto createVehicle(VehicleDto vehicleDto) {
		
		Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
		
		Vehicle savedVehicle = vehicleRepository.save(vehicle);
		
		return VehicleMapper.mapToVehicleDto(savedVehicle);
	}

}