package com.taslitsky;
import com.taslitsky.drink.Drink;
import com.taslitsky.drink.DrinkAdditionalItem;
import com.taslitsky.drink.DrinkBuilder;
import com.taslitsky.drink.DrinkItem;

import java.util.*;

public class DrinkMenuController {
    private static final String CHOICE = "Make your choice:";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private final DrinkBuilder drinkBuilder = new DrinkBuilder();

    public Drink getDrink(Scanner scanner) {
        int input = -1;
        boolean isExit = false;
        do {
            int count = 1;
            try {
                System.out.println("What kind of drink do you prefer?");
                for (DrinkItem drinkItem : DrinkItem.values()) {
                    System.out.println(count + " - Order " + drinkItem);
                    count++;
                }
                System.out.print(CHOICE);
                input = scanner.nextInt();
                if (input >= 1 && input <= count - 1) {
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
        switch (input) {
            case 1 -> {
                drinkBuilder.drink(DrinkItem.PEPSI);
                getDrinkAdditionalItem(DrinkItem.PEPSI, scanner);
            }
            case 2 -> {
                drinkBuilder.drink(DrinkItem.COLA);
                getDrinkAdditionalItem(DrinkItem.COLA, scanner);
            }
            case 3 -> {
                drinkBuilder.drink(DrinkItem.WINE);
                getDrinkAdditionalItem(DrinkItem.WINE, scanner);
            }
            case 4 -> {
                drinkBuilder.drink(DrinkItem.BEER);
                getDrinkAdditionalItem(DrinkItem.BEER, scanner);
            }
        }
        return drinkBuilder.build();
    }

    public void getDrinkAdditionalItem(DrinkItem drinkItem, Scanner scanner) {
        int input = -1;
        boolean isExit = false;
        do {
            int count = 1;
            try {
                System.out.println("What do you want to add to " + drinkItem);
                for (DrinkAdditionalItem drinkAdditionalItem : DrinkAdditionalItem.values()) {
                    System.out.println(count + " - Add " + drinkAdditionalItem);
                    count++;
                }
                System.out.println(count + " - Add LEMON and ICE_CUBES");
                System.out.print(CHOICE);
                input = scanner.nextInt();
                if (input >= 1 && input <= count) {
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
        switch (input) {
            case 1 -> drinkBuilder.additionalItem
                    (new ArrayList<>(List.of(DrinkAdditionalItem.LEMON)));
            case 2 -> drinkBuilder.additionalItem
                    (new ArrayList<>(List.of(DrinkAdditionalItem.ICE_CUBES)));
            case 3 -> drinkBuilder.additionalItem
                    (new ArrayList<>(List.of(DrinkAdditionalItem.NOTHING)));
            case 4 -> drinkBuilder.additionalItem
                    (new ArrayList<>(List.of(DrinkAdditionalItem.LEMON, DrinkAdditionalItem.ICE_CUBES)));
        }
    }
}
