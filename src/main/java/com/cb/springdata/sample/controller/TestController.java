package com.cb.springdata.sample.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.springdata.sample.entities.Building;
import com.cb.springdata.sample.entities.User;
import com.cb.springdata.sample.repositories.BuildingRepository;
import com.cb.springdata.sample.repositories.UserRepository;
import com.cb.springdata.sample.service.BuildingService;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
    private UserRepository userRepository;

	@GetMapping("test")
	public String test() {
		
		User user = null;
		for (int i = 0; i <= 200000; i ++) {
			user = new User();
			user.setId("user1."+UUID.randomUUID().toString());
			user.setName("zjy"+i);
			userRepository.save(user);
			System.out.println(i);
		}
		return "hello";
	}
	
}
