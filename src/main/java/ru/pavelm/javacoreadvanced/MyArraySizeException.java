package ru.pavelm.javacoreadvanced;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(String message, int num) {
        super(message + " Ваше число: " + num);
    }
}
