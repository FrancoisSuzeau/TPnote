package com.uca;


import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Map.Entry;
import java.io.*;
import java.util.*;


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


	public static String getRomanFromNumber(int a) throws IllegalArgumentException
	{
		
		if((a < 1) || (a > 3999))
		{
			throw new IllegalArgumentException();
		}

		String romanNum = "";
		Integer number;
		
		//tools needed to scan the hasmap
		Set<Entry<String, Integer>> set_hash = SYMBOLS.entrySet();
		Iterator<Entry<String, Integer>> it = set_hash.iterator();
		Entry <String, Integer> couple;

		//scanning the hasmap
		while (it.hasNext())
		{
			couple = it.next();
			number = couple.getValue();
			while(a >= number)
			{
				romanNum = romanNum + couple.getKey();
				a = a - number;
			}
		}

		if(romanNum.equals("")) // we never are full prepared
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return romanNum;
		}
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		

		//Testing if the string is good
		if(notAllUpperCase(a))
		{
			throw new IllegalArgumentException();
		}

		int 	countChar = 1;
		int 	parcourString = 0;
		int 	lengthString = a.length();
		char 	charToCompare;
 
		while (parcourString < lengthString)
		{
			charToCompare = a.charAt(parcourString); //input the char to compare with the others of the string
			System.out.println("Testing for " + charToCompare);
			for(int i = parcourString + 1; i < lengthString; i++) //parcour the string right after the one we compare
			{
				if(charToCompare != a.charAt(i)) //if the next char isn't the same then we don't need to compare this one with others
				{
					System.out.println("Not the same");
					break;
				}
				else if((charToCompare == 'V') || (charToCompare == 'L') || (charToCompare == 'D')) //verifying if there is not an invalide pair : VV, LL, DD
				{
					if(a.charAt(i) == charToCompare)
					{
						throw new IllegalArgumentException();
					}
				}
				else if(a.charAt(i) == charToCompare) //counting the number time there is the same char
				{
					System.out.println("same and not V or L or D");
					countChar++;
					if(countChar >= 4) //if countChar is superior than 3 there is a number of invalide repetition of the char
					{
						throw new IllegalArgumentException();
					}
				}
			}
			
			System.out.println("No invalide repetitive char");
			countChar = 1;
			parcourString++;
		}
		
		//all is good now we can convert into int
		/*int resultat = 0;
		int index = 0;
		
		//tools needed to scan the hasmap
		Set<Entry<String, Integer>> set_hash = SYMBOLS.entrySet();
		Iterator<Entry<String, Integer>> it = set_hash.iterator();
		Entry <String, Integer> couple;

		//scanning the hasmap
		while (it.hasNext())
		{
			couple = it.next();
			while(a.substring(index, index + couple.getKey().length()).equals(couple.getKey()))
			{
				try {
					System.out.println("substring : " + a.substring(index, index + couple.getKey().length()));
					System.out.println("symbole : " + couple.getKey());
					resultat = resultat + couple.getValue();
					index = index + couple.getKey().length();
				} catch(Exception e)
				{
					break;
				}
				
			}
		}
		return resultat;*/

		switch(a)
		{
			case "I":
				return 1;
			case "II":
				return 2;
			case "III":
				return 3;
			case "IV":
				return 4;
			case "V":
				return 5;
			case "VI":
				return 6;
			case "VII":
				return 7;
			case "VIII":
				return 8;
			case "IX":
				return 9;
			case "X":
				return 10;
			default:
				throw new IllegalArgumentException();
		}

	}

	public static boolean notAllUpperCase(String ab)
	{
		for (int i = 0; i < ab.length(); i++)
		{
			if(Character.isLowerCase(ab.charAt(i)))
			{
				return true;
			}
		}

		return false;
	}


	/*public static boolean rightSenseReading(String a)
	{
		a.length();
		char currentChar;
		int i = a.length();
		while(i > -1)
		{
			i--;
		}

		return true;
	}*/
}