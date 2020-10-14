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
			throw new IllegalArgumentException("Not a validate value. Must be between [1 : 3999]");
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
			throw new IllegalArgumentException("Convert to Roman failed");
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
			throw new IllegalArgumentException("There is a least one lower case character");
		}

		int 	countChar = 1;
		int 	parcourString = 0;
		int 	lengthString = a.length();
		char 	charToCompare;
 
		while (parcourString < lengthString)
		{
			charToCompare = a.charAt(parcourString); //input the char to compare with the others of the string
			for(int i = parcourString + 1; i < lengthString; i++) //parcour the string right after the one we compare
			{
				if(charToCompare != a.charAt(i)) //if the next char isn't the same then we don't need to compare this one with others
				{
					break;
				}
				else if((charToCompare == 'V') || (charToCompare == 'L') || (charToCompare == 'D')) //verifying if there is not an invalide pair : VV, LL, DD
				{
					if(a.charAt(i) == charToCompare)
					{
						throw new IllegalArgumentException("There is a non-authorized pair : " + charToCompare + a.charAt(i));
					}
				}
				else if(a.charAt(i) == charToCompare) //counting the number time there is the same char
				{
					countChar++;
					if(countChar >= 4) //if countChar is superior than 3 there is a number of invalide repetition of the char
					{
						throw new IllegalArgumentException("There is a non-authorized number of the same character : " + charToCompare);
					}
				}
			}
			
			countChar = 1;
			parcourString++;
		}
		
		//all is good now we can convert into int
		int resultat = 0;
		int index = 0;
		String compare_and_concan = "";
		
		if(a.length() == 1)
		{
			resultat = SYMBOLS.get(a);	
		}
		else
		{
			//tools needed to scan the hasmap
			Set<Entry<String, Integer>> set_hash = SYMBOLS.entrySet();
			Iterator<Entry<String, Integer>> it = set_hash.iterator();
			Entry <String, Integer> couple;
			
			//scanning the hasmap
			while(it.hasNext())
			{
				couple = it.next();
				for(int i = 0; i < a.length(); i++)
				{
					if(i >= index && i < index + couple.getKey().length())
					{
						compare_and_concan = compare_and_concan + Character.toString(a.charAt(i));
					}
				}
				if(compare_and_concan.equals(couple.getKey()))
				{
						resultat = resultat + couple.getValue();
						index = index + couple.getKey().length();
				
						if((couple.getKey() == "I") || (couple.getKey() == "X") || (couple.getKey() == "C") || (couple.getKey() == "M"))
						{
							while((index < a.length()) && Character.toString(a.charAt(index - 1)).equals(Character.toString(a.charAt(index))))
							{
								index++;
								resultat = resultat + couple.getValue();
							}
						}
				}
				compare_and_concan = "";
			}
		}
		return resultat;
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