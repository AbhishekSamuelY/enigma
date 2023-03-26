package com.abhisheksamuely.apps.enigma.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksamuely.apps.enigma.beans.Configuration;
import com.abhisheksamuely.apps.enigma.beans.Rotors;
import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.service.EnigmaService;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

@RestController
@RequestMapping("/enigma")
public class EnigmaContoller {
	
	private EnigmaService service;
	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;
	
	public EnigmaContoller(EnigmaService service, EnigmaConfiguration configuration, EnigmaUtils utils) {
		this.service = service;
		this.configuration = configuration;
		this.utils = utils;
		service.initilize();
	}

	@PostMapping("/setConfig")
	public String setConfiguration(@RequestBody Configuration configuration){
		return service.setConfiguration(configuration.getRotors());
	}

	@PostMapping("/message")
	public String encryptMessage(@RequestBody String message){
		return service.encryptMessage(message);
	}
}
