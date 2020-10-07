package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList; //pour les premiers écrit de isAGoodRoman
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Tests {

    private List<String> RomanNumberList = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
	
	@Test
	/*public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
	}*/
	
    public void allSuccessfullTest()
    {
        //isGoodDecimal();
        isAGoodRoman();
    }

    public void isGoodDecimal()
    {

    }

    public void isAGoodRoman()
    {
        
        Iterator it = this.RomanNumberList.iterator();

        int i = 1;
        while (it.hasNext())
        {
            assertThat(RomanConverter.getNumberFromRoman((String)it.next()), equalTo(i));
            i++;
        }
    }


    /*public void allFailureTest()
    {

    }*/




	


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
