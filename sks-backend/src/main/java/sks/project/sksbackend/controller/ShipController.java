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
import sks.project.sksbackend.dto.ShipDto;
import sks.project.sksbackend.serviceBusiness.ShipService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/ship")
public class ShipController {

	private ShipService shipService;
	
	@GetMapping()
	public ResponseEntity<List<ShipDto>> getAllShip(){
		
		List<ShipDto> ship = shipService.getAllShip();
		
		return ResponseEntity.ok(ship);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ShipDto> getShipById(@PathVariable("id") Long shipId){
		
		ShipDto shipDto = shipService.getShipById(shipId);
		
		return ResponseEntity.ok(shipDto);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ShipDto> updateShip(@PathVariable("id") Long shipId,@RequestBody ShipDto updateShip){		
		
		ShipDto shipDto = shipService.updateShip(shipId, updateShip);
		
		return ResponseEntity.ok(shipDto);
	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteShip(@PathVariable("id") Long shipId){
		
		shipService.deleteShip(shipId);
		
		return ResponseEntity.ok("Gemi silme işlemi başarılı");
		
	}
	
	@PostMapping()
	public ResponseEntity<ShipDto> createShip(@RequestBody ShipDto shipDto){
		
		ShipDto savedShip = shipService.createShip(shipDto);
		
		return new ResponseEntity<>(savedShip,HttpStatus.CREATED);
	
	}
	
	
	
}