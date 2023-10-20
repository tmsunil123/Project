package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int code;
	private String employeeName;
	private String employeeAddress;
	private double salary;
	private int age;
	private String occupation;
	private String emailId;
	
}
