package com.uca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Tests {

    private static List<String> RomanNumberList;

    @BeforeAll
    public static void initList()
    {
        RomanNumberList = new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));
    }

    @AfterAll
    public static void finalizeList()
    {
        RomanNumberList.clear();
    }
    
/**************************************************** Successfull test ****************************************************/
    @Test
    public void isGoodDecimal() //verifing if the output string is reach one
    {
        Iterator it = RomanNumberList.iterator();
        int i = 1;

        while(it.hasNext())
        {
            assertThat(RomanConverter.getRomanFromNumber(i), equalTo(it.next()));
            i++;
        }
    }

    @Test
    public void isAGoodRoman() //verifing if the output integer is reach one
    {
        Iterator it = RomanNumberList.iterator();
        int i = 1;
        while (it.hasNext())
        {
            assertThat(RomanConverter.getNumberFromRoman((String)it.next()), equalTo(i));
            i++;
        }
    }

/**************************************************** failure test ****************************************************/
    @Test
    public void exceptionRising() // test if the exception is rising
    {
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void notInteger() //test the none being of integer
    {
        Assertions.assertFalse(this::isFalse);
    }

    boolean isFalse()
    {
        boolean retour = true;
        double a = 7.5;
        int b = RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber((int)a));
        if (a != b)
        {
            retour = false;
        }

        return retour;
    }

    @Test
    public void outsideInterval() //test if there is an exception rising if the value is not include to [1;3999]
    {
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void tooMuchRepetiveSymbols() //test the rising except if there is to much illegal repetitive symbol
    {
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XIIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XXXX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("LLLL")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void pairRepetitive() //test if the method fail when there is illegal pair repetition
    {
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("LL")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("DD")), instanceOf(IllegalArgumentException.class));
    }

    /*@Test
    public void illegalPrecedingValue() // test if the method fail because of an illegal preceding value (like VX or XCX)
    {

    }*/
    
/**************************************************** validate test ****************************************************/
    @Test
    public void nEqualN() //test the bijection
    {
        for(int i = 1; i < 4000; i++)
        {
                Assertions.assertTrue(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)) == i);
        }
        
    }

    @Test
    public void romanIsCapital() // test if all the roman are upper case
    {
        for(int i = 1; i < 4000; i++)
        {
            Assertions.assertTrue(allUpperCase(i));
        }
    }

    @Test
    public void toRomanUpperCase() //verifing if toRoman return upper Case
    {
        Assertions.assertTrue(this::allUpperCase);
    }

    boolean allUpperCase()
    {
        String testUpperCase = RomanConverter.getRomanFromNumber(8);
        int strlength = testUpperCase.length();
        int countUpperCase = 0;

        for(int i = 0; i < strlength; i++)
        {
            if(Character.isUpperCase(testUpperCase.charAt(i)))
            {
                countUpperCase++;
            }
        }

        if(countUpperCase == strlength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean allUpperCase(int a)
    {
        String testUpperCase = RomanConverter.getRomanFromNumber(a);
        int strlength = testUpperCase.length();
        int countUpperCase = 0;

        for(int i = 0; i < strlength; i++)
        {
            if(Character.isUpperCase(testUpperCase.charAt(i)))
            {
                countUpperCase++;
            }
        }

        if(countUpperCase == strlength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Test
    public void oneLowerCase() //verify if the string in fromRoman is not upper case
    {
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("Xii")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XiI")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("xII")), instanceOf(IllegalArgumentException.class));
    }

    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
