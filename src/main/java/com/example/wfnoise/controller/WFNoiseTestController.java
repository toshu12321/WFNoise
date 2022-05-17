package com.example.wfnoise.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wfnoise.utils.SpeechSynthesis;

@RestController
public class WFNoiseTestController {

	@GetMapping("/test")
	public ResponseEntity<byte[]> test(@RequestParam String  text) throws InterruptedException, ExecutionException {
		return new ResponseEntity<>(SpeechSynthesis.getAudioData(text), HttpStatus.OK);
	}
}
