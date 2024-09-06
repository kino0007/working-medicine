package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.entity.Md;
import com.project.repo.MdRepo;
import com.project.request.MedicineRequest;

@Service
public class MedicineService {

	@Autowired
	MdRepo mdRepo;

	public Md createMedicine(MedicineRequest medicinerequest) {

		Md md = new Md(medicinerequest);
		return mdRepo.save(md);
	}

	public List<Md> getAllMedicine() {

		return mdRepo.findAll();
	}

	public List<Md> getlikeMedicine(String name) {

		return mdRepo.findByNameContains(name);
	}

	public Md getMedicineByName(String name) {
		return mdRepo.findByName(name);
	}

	public String sellByName(String name, int stock) {

		double price;
		int sell = stock;
		Md md = mdRepo.findByName(name);
		price = md.getPrice() * stock;
		stock = md.getStock() - stock;

		if (md.getStock() >= sell) {
			mdRepo.updateByName(name, stock);
			return "medicine is sell and price = " + price;
		} else
			return "You are running out of stock!";
	}

	public String updateByName(String name, MedicineRequest medicineRequest) {

		medicineRequest.setName(name);
		
		Md md = mdRepo.findByName(name);
		int stock = md.getStock() + medicineRequest.getStock();
		return mdRepo.updateByName(name, stock, medicineRequest.getPrice()) + " medicine is updated";
	}

}
