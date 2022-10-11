package com.taslitsky;

import com.taslitsky.drink.DrinkItem;
import com.taslitsky.lunch.CuisineItem;
import com.taslitsky.lunch.DessertItem;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    private int input;
    private final LunchMenuController lunchMenuController =
            new LunchMenuController();
    private final DrinkMenuController drinkMenuController =
            new DrinkMenuController();

    public void welcomeMenu() {
        String menu = GREEN_BACKGROUND
                + " ===== Welcome To Our Restaurant! ====="
                + ANSI_RESET
                + "\n" +
                """
                        ================ Menu ================
                        Lunch Cuisine course :
                        """
                +
                ANSI_GREEN
                +
                Arrays.stream(CuisineItem.values())
                        .map(Enum::toString)
                        .map(str -> str.substring(0, 1).toUpperCase()
                                + str.substring(1).toLowerCase())
                        .collect(Collectors.joining(", ")) +
                ANSI_RESET
                +
                "\n--------------------------------------" +
                "\nDessert : \n" +
                ANSI_GREEN
                +
                Arrays.stream(DessertItem.values())
                        .map(Enum::toString)
                        .map(str -> str.substring(0, 1).toUpperCase()
                                + str.substring(1).toLowerCase())
                        .collect(Collectors.joining(", ")) +
                ANSI_RESET
                +
                "\n--------------------------------------" +
                "\nDrinks : \n" +
                ANSI_GREEN
                +
                Arrays.stream(DrinkItem.values())
                        .map(Enum::toString)
                        .map(str -> str.substring(0, 1).toUpperCase()
                                + str.substring(1).toLowerCase())
                        .collect(Collectors.joining(", ")) +
                ANSI_RESET
                +
                "\n--------------------------------------";
        System.out.println(menu);
    }

    public void getMenu(Scanner scanner) {
        input = -1;
        boolean isExit = false;
        do {
            try {
                System.out.print("""
                        =====Please make your order=====
                        Do you want lunch or just drink?
                        1 - Order lunch
                        2 - Order drink
                        3 - Show menu
                        0 - Exit
                        Make your choice:""");
                input = scanner.nextInt();
                if (input >= 0 && input <= 3) {
                    isExit = true;
                } else {
                    System.out.println(ANSI_RED + "!!!No such menu item.Try again!!!" + ANSI_RESET);
                    scanner.nextLine();
                }
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED + "!!!Wrong input.Try again!!!" + ANSI_RESET);
                scanner.nextLine();
            }
        } while (!isExit);
    }

    public boolean getUserInput(Scanner scanner) {
        boolean isExit = false;
        getMenu(scanner);
        switch (input) {
            case 0 -> {
                isExit = true;
                scanner.close();
            }
            case 1 -> System.out.println(lunchMenuController.getLunch(scanner));
            case 2 -> System.out.println(drinkMenuController.getDrink(scanner));
            case 3 -> welcomeMenu();
        }
        return isExit;
    }
}
