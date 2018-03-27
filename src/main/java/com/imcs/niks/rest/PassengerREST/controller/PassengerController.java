package com.imcs.niks.rest.PassengerREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.niks.passengerrepo.entity.PassengerProfile;
import com.imcs.niks.passengerrepo.service.IPassengerService;

@RestController
public class PassengerController {

	@Autowired
	private IPassengerService service;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/passengers")
	public ResponseEntity<?> getPassengers() {

		return new ResponseEntity(service.getAllPassengers(), HttpStatus.ACCEPTED);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/passengers/{id}")
	public ResponseEntity<?> getPassengersById(@PathVariable("id") Integer id) {

		return new ResponseEntity(service.getPassengerById(id), HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path="/passengers")
	public ResponseEntity savePassenger(@RequestBody PassengerProfile passenger){
		service.savePassenger(passenger);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(path="/passengers")
	public ResponseEntity updatePassenger(@RequestBody PassengerProfile passenger){
		service.updatePassenger(passenger);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(path = "/passengers/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		service.deletePassengerById(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	

}
