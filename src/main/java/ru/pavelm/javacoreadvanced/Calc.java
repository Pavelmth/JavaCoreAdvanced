package ru.pavelm.javacoreadvanced;

public class Calc extends Thread {
    private int size;
    private float[] arr;

    public Calc(float[] arr, int size) {
        this.size = size;
        this.arr = arr;
    }

    public float[] getArr() {
        return this.arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.size; i++) {
            this.arr[i] = (float) (this.arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

