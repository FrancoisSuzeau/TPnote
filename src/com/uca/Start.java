package com.uca;

public class Start{
	
	//Start class
	public static void main(String[] args) throws IllegalArgumentException{

		RomanNumber roman = new RomanNumber();

		if(args.length == 0)
		{
			throw new IllegalArgumentException("No argument found");
		}
		else
		{
			try {
				roman.setValue(Integer.parseInt(args[0])); // it is a string like 10 or 25 then to int
			} catch(NumberFormatException e)
			{
				roman.setRoman(args[0]); //it may be is a roman value like IV or XXV
			}
		
			/*System.out.println(roman.getValue());
			System.out.println(roman.getRoman());*/

			System.out.println("intValue : " + roman.intValue());
			System.out.println("doubleValue : " + roman.doubleValue());
			System.out.println("floatValue : " + roman.floatValue());
			System.out.println("longValue : " + roman.longValue());
			System.out.println("toString : " + roman.toString());

			roman.compareToAnotherRomanNumber(new RomanNumber("VII"));
			
		}
		
		
		//TODO
		//Aide pour démarrer : https://git.artheriom.fr/l3-informatique-2020-2021/site-l3/-/tree/master/Genie_Logiciel/HelperTP3
		//Aussi : https://www.youtube.com/watch?v=567_hWQJYak
	}
	
}