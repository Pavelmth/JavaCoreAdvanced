package ru.pavelm.javacoreadvanced;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App
{
    public static void main( String[] args )
    {
        String[][] array = new String[4][4];

        try {
            array = createArray(array);
        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        //внедряем ошибку
        //array[2][2] = "foo";

        try {
            sumArray(array);
        }
        catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println(DayOfWeek.MONDAY.getWorkingHours());
    }

    public static String[][] createArray (String [][] array) throws MyArraySizeException {

        if (array.length != 4) {
            throw new MyArraySizeException("Введенное число не равно 4", array.length);
        }
        if (array[0].length != 4) {
            throw new MyArraySizeException("Введенное число не равно 4", array[0].length);
        }

        //Создаем случайное число и заполняем массив строками в виде числа
        Random random = new Random();
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4; j++) {
                int integer = random.nextInt(100) + 1;
                array[i][j] = String.valueOf(integer);
            }
        }
        return array;
    }

    public static void sumArray (String[][] array) throws MyArrayDataException {
        int sum = 0;
        String pattern = "(.*)(\\d+)(.*)";
        Pattern r = Pattern.compile(pattern);

        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4; j++) {
                Matcher m = r.matcher(array[i][j]);
                if (m.find( )) {
                    Integer.parseInt(array[i][j]);
                    sum += Integer.valueOf(array[i][j]);
                } else {
                    throw new MyArrayDataException("Невозможно преобразовать число в ячейке ", i, j);
                }
            }
        }
        System.out.println(sum);
    }
}

