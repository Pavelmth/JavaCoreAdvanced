package ru.pavelm.javacoreadvanced;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int i, int j) {
        super(message + "X = " + i + ", Y = " + j);
    }
}
