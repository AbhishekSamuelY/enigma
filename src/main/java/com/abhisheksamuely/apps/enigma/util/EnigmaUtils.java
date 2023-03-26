package com.abhisheksamuely.apps.enigma.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.security.auth.login.Configuration;

import org.springframework.stereotype.Component;

import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EnigmaUtils {
	
	private	EnigmaConfiguration configuration;
	
	public EnigmaUtils(EnigmaConfiguration configuration) {
		this.configuration = configuration;
	}

	public Map<String,String> mapRotorSettings(String rotorString){
		Map<String,String> rotorMapped = new HashMap<>();
		for(int i = 0; i <= 26; i++) {
			if(i == 0) {
				rotorMapped.put(configuration.getEnglishLetters().get(i), rotorString.substring(0, 1));
			} else {
				rotorMapped.put(configuration.getEnglishLetters().get(i), rotorString.substring(i-1, i));
			}
		}
		return rotorMapped;
	}
	
	public void printMapping(String gear, Map<Integer, Integer> letterMapping) {
		System.out.println("Mapping for: "+gear);
		Set<Integer> keys = letterMapping.keySet();
		for (Integer letter : keys) {
			System.out.print("'" + configuration.getEnglishLetters().get(letter) + ":" +configuration.getEnglishLetters().get(letterMapping.get(letter)) + "',");
		}
		System.out.println();
	}

	public void printPlugBoardConnections(Map<Integer, Integer> plugBoard) {
		System.out.println("PlugBorad Connections");
		Set<Integer> keys = plugBoard.keySet();
		for (Integer letter : keys) {
			System.out.print("'" + configuration.getEnglishLetters().get(letter) + "' -> '" +configuration.getEnglishLetters().get(plugBoard.get(letter)) + "',");
		}
		System.out.println();
	}

	public Map<Integer, Integer> reMapRotor(Map<Integer, Integer> rotorMapping) {
		Map<Integer, Integer> newRotorMap = new HashMap<>();
		Set<Integer> keys = rotorMapping.keySet();
		for(int key : keys) {
			newRotorMap.put(key, rotorMapping.get(key+1));
		}
		newRotorMap.put(26, rotorMapping.get(1));
		return newRotorMap;
	}
}
