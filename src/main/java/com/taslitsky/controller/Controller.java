package com.taslitsky.controller;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final Menu menu = new Menu();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isExit = false;
        menu.welcomeMenu();
        while (!isExit) {
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(new Timer());
            isExit = (menu.getUserInput(scanner));
            service.shutdownNow();
        }
    }

    private static class Timer implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(60);
                System.out.println("\nToo long wait for input! ");
                System.exit(0);
            } catch (InterruptedException e) {
                System.out.print("");
            }
        }
    }
}
