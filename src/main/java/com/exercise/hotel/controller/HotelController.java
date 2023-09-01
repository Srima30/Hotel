package com.exercise.hotel.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.hotel.model.HotelEntity;
import com.exercise.hotel.service.HotelService;



@RestController
public class HotelController {
	@Autowired
	HotelService service;
	
	@PostMapping("adddish")
	public HotelEntity add(@RequestBody HotelEntity entity) {
		return service.saveinfo(entity);
	}
	@PostMapping("addndishes")
	public List<HotelEntity> addndetails(@RequestBody List<HotelEntity> entity){
		return service.savedetails(entity);
	}
	
	@GetMapping("showdetails")
	public List<HotelEntity> show(){
		return service.showinfo();
		
	}
	//show by id
	@GetMapping("showdetbyid/{id}")
		public Optional<HotelEntity> showid(@PathVariable int id){
			return service.showbyid(id);
		}
	
	@PutMapping("update")
	public HotelEntity modify(@RequestBody HotelEntity entity ) {
		return service.changeinfo(entity);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody HotelEntity entity) {
		return service.updateinfobyid(id,entity);
	}
	@DeleteMapping("deletedetail")
		public String del(@RequestBody HotelEntity entity) {
			service.deleteinfo(entity);
			return "Deleted successfully";
		}
	
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id) {
		service.deleteid(id);
	}
	
	@DeleteMapping("delparamid")
	public void deletemyparamid (@RequestParam int id) {
		service.deletepid(id);
	}
	}