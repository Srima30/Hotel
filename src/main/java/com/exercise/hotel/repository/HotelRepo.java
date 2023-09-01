package com.exercise.hotel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.exercise.hotel.model.HotelEntity;


public interface HotelRepo extends JpaRepository<HotelEntity, Integer>{
	

}