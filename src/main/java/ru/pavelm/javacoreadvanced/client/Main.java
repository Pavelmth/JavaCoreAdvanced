package ru.pavelm.javacoreadvanced.client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner input = new Scanner(System.in);
        String str = "";

        while (!str.equals("/end")) {
            str = input.nextLine();
            client.sendMsg(str);
        }
    }
}

