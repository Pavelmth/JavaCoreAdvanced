package ru.pavelm.javacoreadvanced;

public class App {
    public static void main(String[] args) {
        System.out.println("One stream");
        zeroCalc();
        System.out.println("\nuse class Thread");
        firstCalc();
        System.out.println("\nuse Lambda");
        secondCalc();
    }

    static void zeroCalc() {
        final int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Calculating time by one thread: " + (System.currentTimeMillis() - a));
    }

    static void firstCalc() {
        final int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        final long a = System.currentTimeMillis();
        final int numberThreads = 4;
        final int h = arr.length / numberThreads;
        float[][] mass = new float[numberThreads][h];

        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(arr, (i*h), mass[i], 0, h);
        }
        System.out.println("Dividing time of array by " + numberThreads + ": " + (System.currentTimeMillis() - a));

        final long b = System.currentTimeMillis();
        Calc[] massCalc = new Calc[numberThreads];
        for (int i = 0; i < numberThreads; i++) {
            massCalc[i] = new Calc(mass[i], h);
        }
        for (Calc oneCalc: massCalc) {
            oneCalc.start();
        }
        for (Calc oneCalc: massCalc) {
            try {
                oneCalc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Calculating time by " + numberThreads + " threads: " + (System.currentTimeMillis() - b));

        final long c = System.currentTimeMillis();
        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(massCalc[i].getArr(), 0, arr, (i*h), h);
        }
        System.out.println("Merging time of array: " + (System.currentTimeMillis() - c));
    }

    static void secondCalc() {
        final int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        final long a = System.currentTimeMillis();
        final int numberThreads = 4;
        final int h = arr.length / numberThreads;
        float[][] mass = new float[numberThreads][h];

        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(arr, (i*h), mass[i], 0, h);
        }

        System.out.println("Dividing time of array by " + numberThreads + ": " + (System.currentTimeMillis() - a));

        final long b = System.currentTimeMillis();

        System.out.println("Checking value - " + arr[1]);//fvwrfevqrfevcqewrfcvqerfcrdfqdwcwddrewcqdewcccccccccccccccccccccccccccccccccccccccccccccccccc

        for (float[] arrT: mass) {
            new Thread(() -> {
                for (int i = 0; i < h; i++) {
                    arrT[i] = (float) (arrT[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }).start();
        }

        System.out.println("Calculating time by " + numberThreads + " threads: " + (System.currentTimeMillis() - b));

        System.out.println("Checking value - " + mass[0][1]);//cccdcccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc

        final long c = System.currentTimeMillis();
        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(mass[i], 0, arr, (i*h), h);
        }
        System.out.println("Merging time of array: " + (System.currentTimeMillis() - c));
    }
}