package com.abhisheksamuely.apps.enigma.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

public class PlugBoard {
	
	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;
	
	Map<Integer, Integer> plugBoard = new HashMap<>();

	public PlugBoard(EnigmaConfiguration configuration, EnigmaUtils utils) {
		this.configuration = configuration;
		this.utils = utils;
		
		boolean isPlugBoardConfigured = true;
		Scanner scanner = new Scanner(System.in);
		while(isPlugBoardConfigured) {
			System.out.println("Enter any two space seperated letters for plugboard connection, eg:A B");
			String letters = scanner.nextLine();
			scanner.close();
			if(letters.split(" ").length != 2) {
				System.out.println("Invalid Inputs! letters must be space seperated");
			} else if(letters.split(" ").length < 2) {
				System.out.println("Invalid Inputs! please enter two letters");
			} else {
				String[] plugBoardInputs = letters.split(" ");
				plugBoard.put(configuration.getNumbersToLetters().get(plugBoardInputs[0]), configuration.getNumbersToLetters().get(plugBoardInputs[1]));
				plugBoard.put(configuration.getNumbersToLetters().get(plugBoardInputs[1]), configuration.getNumbersToLetters().get(plugBoardInputs[0]));
				utils.printPlugBoardConnections(plugBoard);
				System.out.println("Add more PlugBorad connections y/n?");
				Scanner internalScanner = new Scanner(System.in);
				String input = null;
				while(internalScanner.hasNextLine()) {
					input = internalScanner.nextLine();
					scanner.close();
				}
				if(!input.equalsIgnoreCase("y")) {
					isPlugBoardConfigured = false;
				}
			}
		}
		
	}
	
	

}
