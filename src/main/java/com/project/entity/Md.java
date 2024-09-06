package com.project.entity;

import com.project.request.MedicineRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "md")
public class Md {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "price")
	private double price;
	
	
	public Md(MedicineRequest medicinerequest) {
		
		this.name = medicinerequest.getName();
		this.stock = medicinerequest.getStock();
		this.price = medicinerequest.getPrice();
		
	}

}
