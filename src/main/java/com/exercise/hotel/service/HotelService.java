package com.exercise.hotel.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.hotel.model.HotelEntity;
import com.exercise.hotel.repository.HotelRepo;

@Service
public class HotelService {
	@Autowired
	HotelRepo repo;
	
	public HotelEntity saveinfo(HotelEntity entity) {
		return repo.save(entity);
	}
	public List<HotelEntity> savedetails(List<HotelEntity> entity){
		return (List<HotelEntity>)repo.saveAll(entity);
	}
	public List<HotelEntity> showinfo(){
		return repo.findAll();
	}
	public Optional<HotelEntity> showinfo(int id){
		return repo.findById(id);
	}
	//get by id
	public Optional<HotelEntity> showbyid(int id){
		return repo.findById(id);
	}
	public HotelEntity changeinfo(HotelEntity entity) {
		return repo.saveAndFlush(entity);
	}
	
	public String updateinfobyid(int id,HotelEntity entity) {
		repo.saveAndFlush(entity);
		if(repo.existsById(id)) {
			return "UPDATED";
		}
		else {
			return "Enter valid id";
		}
	}
	public void deleteinfo(HotelEntity entity) {
		repo.delete(entity);
	}
	
	public void deleteid(int id) {
		repo.deleteById(id);
	}
	
	public void deletepid(int id) {
		repo.deleteById(id);
	}
	

}