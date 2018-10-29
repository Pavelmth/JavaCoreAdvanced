package ru.pavelm.javacoreadvanced;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void reit() {
        ArrayList<String> listFood = new ArrayList<>();
        listFood.add("cheese");
        listFood.add("milk");
        listFood.add("bread");
        listFood.add("meat");
        listFood.add("chicken");

        HashSet<String> repeated = new HashSet<>();
        int n;
        for (int i = 0; i < listFood.size(); i++) {
            n = 0;
            for (String a: listFood) {
                if (listFood.get(i).equalsIgnoreCase(a)) {
                    n++;
                }
            }
            if (n > 1) {
                repeated.add(listFood.get(i));
            }
        }

        Iterator<String> iter = listFood.iterator();
        Iterator<String> iterRepeated = repeated.iterator();
        while (iter.hasNext() && iterRepeated.hasNext()) {
            if (iter.next().equalsIgnoreCase(iterRepeated.next())) {
                iter.remove();
            }
        }
    }

    @Test
    public void regex() {
        System.out.println("Введите пароль");
        String password = "passWord1";
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);
    }
}
