package com.example.demo.model;

import javax.persistence.Column;
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
public class Rooms {
    
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int roomId;
	
	private String floor;
	
	private String type;
	
	private String price;
		
}
