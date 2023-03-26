package com.abhisheksamuely.apps.enigma.configuration;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class EnigmaConfiguration {

	@Value("#{${enigma.rotor.one}}")
	private Map<Integer, Integer> rotorOne;

	@Value("#{${enigma.rotor.two}}")
	private Map<Integer, Integer> rotorTwo;

	@Value("#{${enigma.rotor.three}}")
	private Map<Integer, Integer> rotorThree;

	@Value("#{${enigma.rotor.four}}")
	private Map<Integer, Integer> rotorFour;

	@Value("#{${enigma.rotor.five}}")
	private Map<Integer, Integer> rotorFive;

	@Value("#{${enigma.rotor.six}}")
	private Map<Integer, Integer> rotorSix;

	@Value("#{${enigma.rotor.seven}}")
	private Map<Integer, Integer> rotorSeven;

	@Value("#{${enigma.rotor.eight}}")
	private Map<Integer, Integer> rotorEight;
	
	@Value("#{${enigma.reflector.a}}")
	private Map<Integer, Integer> reflectorA;
	
	@Value("#{${enigma.reflector.b}}")
	private Map<Integer, Integer> reflectorB;
	
	@Value("#{${enigma.reflector.c}}")
	private Map<Integer, Integer> reflectorC;
	
	@Value("#{${enigma.reflector.b.thin}}")
	private Map<Integer, Integer> reflectorBThin;
	
	@Value("#{${enigma.reflector.c.thin}}")
	private Map<Integer, Integer> reflectorCThin;
	
	@Value("#{${enigma.english.letters}}")
	private Map<Integer, String> englishLetters;
	
	@Value("#{${enigma.numbers.letters}}")
	private Map<String, Integer> numbersToLetters;
	
	@Value("${enigma.rotor.one.notch}")
	private Integer rotorOneNotch;
	
	@Value("${enigma.rotor.two.notch}")
	private Integer rotorTwoNotch;
	
	@Value("${enigma.rotor.three.notch}")
	private Integer rotorThreeNotch;
	
	@Value("${enigma.rotor.four.notch}")
	private Integer rotorFourNotch;
	
	@Value("${enigma.rotor.five.notch}")
	private Integer rotorFiveNotch;
	
	@Value("${enigma.rotor.six.notch}")
	private Integer rotorSixNotch;
	
	@Value("${enigma.rotor.seven.notch}")
	private Integer rotorSevenNotch;
	
	@Value("${enigma.rotor.eight.notch}")
	private Integer rotorEightNotch;
	
	@Value("${enigma.rotor.one.name}")
	private String rotorOneName;
	
	@Value("${enigma.rotor.two.name}")
	private String rotorTwoName;
	
	@Value("${enigma.rotor.three.name}")
	private String rotorThreeName;
	
	@Value("${enigma.rotor.four.name}")
	private String rotorFourName;
	
	@Value("${enigma.rotor.five.name}")
	private String rotorFiveName;
	
	@Value("${enigma.rotor.six.name}")
	private String rotorSixName;
	
	@Value("${enigma.rotor.seven.name}")
	private String rotorSevenName;
	
	@Value("${enigma.rotor.eight.name}")
	private String rotorEightName;

}
