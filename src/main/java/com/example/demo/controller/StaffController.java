package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;

@RestController
@RequestMapping("/staffcontroller")
@CrossOrigin("*")
public class StaffController {
 
	@Autowired
     private StaffRepository staffRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/staff")
	public List<Staff> allStaff(){
		return staffRepository.findAll();
	}
	
	@GetMapping("/staff/{code}")
	public ResponseEntity<Staff> getStaffByCode(@PathVariable int code) throws ResourceNotFoundException {
		Staff staff = staffRepository.findById(code)
				.orElseThrow(()-> new ResourceNotFoundException("Staff not found for this code :" + code));
		return ResponseEntity.ok().body(staff);
	}
	
	@PostMapping("/staff")
	 public Staff addStaff(@RequestBody Staff staff) {
		return staffRepository.save(staff); 
	 }
	 
	@PutMapping("/staff/{code}")
	public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff,@PathVariable int code) throws ResourceNotFoundException {
		 Staff updateStaff = staffRepository.findById(code)
				 .orElseThrow(()-> new ResourceNotFoundException("Staff not found for this code :" + code));
		 updateStaff.setEmployeeName(staff.getEmployeeName());
		 updateStaff.setEmployeeAddress(staff.getEmployeeAddress());
		 updateStaff.setSalary(staff.getSalary());
		 updateStaff.setAge(staff.getAge());
		 updateStaff.setOccupation(staff.getOccupation());
		 updateStaff.setEmailId(staff.getEmailId());
		 staffRepository.save(updateStaff);
		 return ResponseEntity.ok(updateStaff);
	}
	
	@DeleteMapping("/staff/{code}")
	public ResponseEntity<HttpStatus> deleteStaff(@PathVariable int code)throws ResourceNotFoundException {
		Staff staff = staffRepository.findById(code)
		.orElseThrow(()-> new ResourceNotFoundException("Staff not found for this code :" + code));
		staffRepository.delete(staff);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@GetMapping("/searchroom")
    public List<Object> getSearch(){
        Object[] objects=restTemplate.getForObject("http://ReceptionistService/roomscontroller/allrooms",Object[].class);
        return Arrays.asList(objects);
    }
}

