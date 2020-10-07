package com.uca;


import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
	static {
		SYMBOLS.put("M",  1000);
		SYMBOLS.put("CM", 900);
		SYMBOLS.put("D",  500);
		SYMBOLS.put("CD", 400);
		SYMBOLS.put("C",  100);
		SYMBOLS.put("XC", 90);
		SYMBOLS.put("L",  50);
		SYMBOLS.put("XL", 40);
		SYMBOLS.put("X",  10);
		SYMBOLS.put("IX", 9);
		SYMBOLS.put("V",  5);
		SYMBOLS.put("IV", 4);
		SYMBOLS.put("I", 1);
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		//TODO
		return "";
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		//TODO
		return 0;
	}
}