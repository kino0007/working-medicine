package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Md;
import com.project.request.MedicineRequest;
import com.project.response.MedicineResponse;
import com.project.service.MedicineService;

@RestController
//@RequestMapping("/api/medicine/")
@CrossOrigin(origins = "http://127.0.0.1:8082")
public class DataController {

	@Autowired
	MedicineService medicineService;
	
	@RequestMapping(value = "/")
	   public String index() {
	      return "index";
	   }
	
	@PostMapping("create")
	public MedicineResponse createMedicine(@RequestBody MedicineRequest medicineRequest) {
		
		System.out.println("in controller");
		
		Md md = medicineService.createMedicine(medicineRequest);
		return new MedicineResponse(md);

	}
	
	@GetMapping("getall")
	public List<MedicineResponse> getAllMedicine() {
		List<Md> list = medicineService.getAllMedicine();
		List<MedicineResponse> medicineResponseList = new ArrayList<MedicineResponse>();

		list.stream().forEach(md -> {
			medicineResponseList.add(new MedicineResponse(md));
		});

		return medicineResponseList;
	}
	
	@GetMapping("getbyname/{name}")
	public MedicineResponse getMedicineByName(@PathVariable String name) {
		Md md =  medicineService.getMedicineByName(name);
		
		return new MedicineResponse(md);
	}
	
	
	@GetMapping("getlike/{name}")
	public List<MedicineResponse> getAllLikeMedicine(@PathVariable String name) {
		List<Md> list = medicineService.getlikeMedicine(name);
		List<MedicineResponse> medicineResponseList = new ArrayList<MedicineResponse>();

		list.stream().forEach(md -> {
			medicineResponseList.add(new MedicineResponse(md));
		});

		return medicineResponseList;
	}
//	@CrossOrigin(origins = "http://127.0.0.1:8082")
	@PutMapping("sellbyname/{name}/{sell}")
	public String sellByName(@PathVariable String name, @PathVariable("sell") int stock) {
		return medicineService.sellByName(name, stock);
	}

	@PutMapping("updatebyname/{name}")
	public String updateByName(@PathVariable String name, @RequestBody MedicineRequest medicineRequest) {
		return medicineService.updateByName(name, medicineRequest);
	}
	
}
