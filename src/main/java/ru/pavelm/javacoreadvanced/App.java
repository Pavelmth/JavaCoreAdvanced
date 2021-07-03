package ru.pavelm.javacoreadvanced;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class App {
    public static void main(String[] args) {
        //System.out.println("One stream");
        //zeroCalc();
        //System.out.println("\nuse class Thread");
        //firstCalc();
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
        final int numberThreads = 8;
        final int h = arr.length / numberThreads;
        float[][] mass = new float[numberThreads][h];

        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(arr, (i*h), mass[i], 0, h);
        }

        System.out.println("Dividing time of array by " + numberThreads + ": " + (System.currentTimeMillis() - a));

        final long b = System.currentTimeMillis();

        System.out.println("Checking value - " + arr[1]);//fvwrfevqrfevcqewrfcvqerfcrdfqdwcwddrewcqdewcccccccccccccccccccccccccccccccccccccccccccccccccc

        final int[] n = {0};

        Thread[] t = new Thread[numberThreads];
        for (int i = 0; i < numberThreads; i++) {
            final int nnn = i;
            t[i] = new Thread(() -> {
                for (int j = 0; j < h; j++) {
                    mass[nnn][j] = (float) (mass[nnn][j] * Math.sin(0.2f + (j*nnn) / 5) * Math.cos(0.2f + (j*nnn) / 5) * Math.cos(0.4f + (j*nnn) / 2));
                }
            });
            t[i].start();

            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Merging time of array: " + (System.currentTimeMillis() - b));
//        Thread[] t = new Thread[numberThreads];
//        for (int i = 0; i < numberThreads; i++) {
//            // будем копировать в двумерный массив данные из основного потока со сдвигом
//            final int u = i;
//            t[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    // считаем массив со сдвигом
//                    int n = u * h;
//                    for (int j = 0; j < h; j++, n++) {
//                        mass[u][j] = (float) (mass[u][j] * Math.sin(0.2f + n / 5) * Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
//                    }
//                }
//            });
//            t[i].start();
//        }
//        try {
//            for (int i = 0; i < numberThreads; i++) {
//                t[i].join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Checking value - " + mass[0][1]);//cccdcccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc

        final long c = System.currentTimeMillis();
        for (int i = 0; i < numberThreads; i++) {
            System.arraycopy(mass[i], 0, arr, (i*h), h);
        }
        System.out.println("Merging time of array: " + (System.currentTimeMillis() - c));
    }
}