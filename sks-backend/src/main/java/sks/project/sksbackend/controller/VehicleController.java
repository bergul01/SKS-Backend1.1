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
import sks.project.sksbackend.dto.VehicleDto;
import sks.project.sksbackend.serviceBusiness.VehicleService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	private VehicleService vehicleService;
	
	@GetMapping()
	public ResponseEntity<List<VehicleDto>> getAllVehicle(){
		
		List<VehicleDto> vehicle = vehicleService.getAllVehicle();
		
		return ResponseEntity.ok(vehicle);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long vehicleId){
		
		VehicleDto vehicleDto = vehicleService.getVehicleById(vehicleId);
		
		return ResponseEntity.ok(vehicleDto);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") Long vehicleId,@RequestBody VehicleDto updateVehicle){		
		
		VehicleDto vehicleDto = vehicleService.updateVehicle(vehicleId, updateVehicle);
		
		return ResponseEntity.ok(vehicleDto);
	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId){
		
		vehicleService.deleteVehicle(vehicleId);
		
		return ResponseEntity.ok("Araç silme işlemi başarılı");
		
	}
	
	@PostMapping()
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
		
		VehicleDto savedVehicle = vehicleService.createVehicle(vehicleDto);
		
		return new ResponseEntity<>(savedVehicle,HttpStatus.CREATED);
	
	}
	
	
	
}
