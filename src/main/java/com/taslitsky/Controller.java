package com.taslitsky;

import java.util.Scanner;

public class Controller {
    private static final Menu menu = new Menu();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isExit = false;
        menu.welcomeMenu();
        while (!isExit) {
            isExit = menu.getUserInput(scanner);
        }
    }
}
