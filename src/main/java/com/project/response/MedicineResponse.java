package com.project.response;

import com.project.entity.Md;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicineResponse {
	
	private int id;
	private String name;
	private int stock;
	private double price;
	
	public MedicineResponse(Md md) {
		this.id = md.getId();
		this.name = md.getName();
		this.stock = md.getStock();
		this.price = md.getPrice();
	}

}
