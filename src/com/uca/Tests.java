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
