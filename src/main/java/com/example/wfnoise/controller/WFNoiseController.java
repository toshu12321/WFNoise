package com.example.wfnoise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/WFNoise")
public class WFNoiseController {

	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
}
