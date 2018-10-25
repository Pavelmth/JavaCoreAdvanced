package ru.pavelm.javacoreadvanced;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void randomStr() {
        Random random = new Random();
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4; j++) {
                int integer = random.nextInt(100) + 1;
                String numString = String.valueOf(integer);
            }
        }
    }
}

