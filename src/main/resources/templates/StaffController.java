package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;

@RestController
@RequestMapping("/staffcontroller")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@GetMapping("/allstaffs")
	public List<Staff> getAllStaff() {
		return staffService.getAllStaff();
	}

	
	@PostMapping("/staffs")
	private Staff saveStaff(@RequestBody Staff staff) {
		staffService.save(staff);
		return staff;
	}
	
/*	@PutMapping("/updatestaff/{code}")
	private Staff update(@RequestBody Staff staff) {
		staffService.update(staff);
		return staff;
	}
	
	@DeleteMapping("/deletestaff/{code}")
	private String deletestaff(@PathVariable  int code) {
		 return  staffService.delete(code);
		
	}*/
	
	@PutMapping("/updatastaff/{code}")
	public Staff update(@RequestBody Staff staff, @PathVariable int code) {
		return staffService.update(staff,code);
	}
	
	@DeleteMapping("/deletestaff/{code}")
	public String delete(@PathVariable int code) {
		return staffService.delete(code);
	}
}
