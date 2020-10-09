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
    public void exceptionRising() // test the exception rising
    {
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XX")), instanceOf(IllegalArgumentException.class));
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
    public void outsideInterval()
    {
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void tooMuchRepetiveSymbols()
    {
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XIIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void pairRepetitive()
    {
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("LL")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("DD")), instanceOf(IllegalArgumentException.class));
    }
    
/**************************************************** validate test ****************************************************/
    @Test
    public void nEqualN()
    {
        for(int i = 1; i < 11; i++)
        {
            Assertions.assertTrue(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)) == i);
        }
        
    }

    @Test
    public void toRomanUpperCase()
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

    @Test
    public void oneLowerCase()
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
