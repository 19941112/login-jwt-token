package com.java.login.jwt.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.login.jwt.bo.ResponseData;
import com.java.login.jwt.service.ReadService;

@RestController
public class ReadController {

	@Autowired
	ReadService readService;
	
	@GetMapping(value="/read")
	public List<ResponseData> read() {
				
		return readService.read();
	}
}
