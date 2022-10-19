package com.taslitsky.controller;

import com.taslitsky.drink.Drink;
import com.taslitsky.drink.DrinkItem;
import com.taslitsky.json.JsonWriter;
import com.taslitsky.lunch.CuisineItem;
import com.taslitsky.lunch.DessertItem;
import com.taslitsky.lunch.Lunch;
import com.taslitsky.order.OrderBuilder;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    private final LunchMenuController lunchMenuController =
            new LunchMenuController();
    private final DrinkMenuController drinkMenuController =
            new DrinkMenuController();
    private final OrderBuilder orderBuilder = new OrderBuilder();

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

    public int getMenu(Scanner scanner) {
        int input = 0;
        boolean isExit = false;
        do {
            try {
                System.out.print("""
                        =====Please make your order=====
                        Do you want lunch or just drink?
                        1 - Order lunch
                        2 - Order drink
                        3 - Show my order
                        4 - Place my order
                        5 - Show menu
                        0 - Exit
                        Make your choice:""");
                input = scanner.nextInt();
                if (input >= 0 && input <= 5) {
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
        return input;
    }

    public boolean getUserInput(Scanner scanner) {
        int input = getMenu(scanner);
        switch (input) {
            case 0 -> {
                scanner.close();
                return true;
            }
            case 1 -> {
                Lunch lunch;
                lunch = lunchMenuController.getLunch(scanner);
                System.out.println(lunch);
                orderBuilder.lunch(lunch);
            }
            case 2 -> {
                Drink drink;
                drink = drinkMenuController.getDrink(scanner);
                System.out.println(drink);
                orderBuilder.drink(drink);
            }
            case 3 -> System.out.println(orderBuilder.build());
            case 4 -> {
                JsonWriter jsonWriter = new JsonWriter();
                jsonWriter.createJson(orderBuilder.build());
            }
            case 5 -> welcomeMenu();
        }
        return false;
    }

}
