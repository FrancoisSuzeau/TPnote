package com.uca;

public class RomanNumber extends Number{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	public boolean compareToAnotherRomanNumber(RomanNumber anotherRN)
	{
		if(Integer.valueOf(this.intValue()).compareTo(Integer.valueOf(anotherRN.intValue())) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		double dvalue = this.getValue();
		return dvalue;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		/*float fvalue = this.getValue();
		return fvalue;*/
		return this.getValue();
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		// TODO
		return this.getValue();
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		long lvalue = this.getValue();
		return lvalue;
	}

	@Override
	public String toString() {
		//TODO
		return this.getRoman();
	}
}