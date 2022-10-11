package com.taslitsky;

import com.taslitsky.cuisine.ItalianCourse;
import com.taslitsky.cuisine.MexicanCourse;
import com.taslitsky.cuisine.PolishCourse;
import com.taslitsky.lunch.CuisineItem;
import com.taslitsky.lunch.DessertItem;
import com.taslitsky.lunch.Lunch;
import com.taslitsky.lunch.LunchBuilder;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LunchMenuController {
    private static final String CHOICE = "Make your choice:";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private final LunchBuilder lunchBuilder = new LunchBuilder();

    public Lunch getLunch(Scanner scanner) {
        int input = -1;
        boolean isExit = false;
        do {
            int count = 1;
            try {
                System.out.println("What cuisine do you prefer?");
                for (CuisineItem cuisineItem : CuisineItem.values()) {
                    System.out.println(count + " - Order " + cuisineItem);
                    count++;
                }
                input = getUserInput(scanner, count);
                isExit = true;
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED + "!!!Wrong input.Try again!!!" + ANSI_RESET);
                scanner.nextLine();
            }
        } while (!isExit);
        switch (input) {
            case 1 -> {
                lunchBuilder.cuisine(CuisineItem.ITALIAN);
                getCourse(scanner, CuisineItem.ITALIAN);
                getDessert(scanner);
            }
            case 2 -> {
                lunchBuilder.cuisine(CuisineItem.MEXICAN);
                getCourse(scanner, CuisineItem.MEXICAN);
                getDessert(scanner);
            }
            case 3 -> {
                lunchBuilder.cuisine(CuisineItem.POLISH);
                getCourse(scanner, CuisineItem.POLISH);
                getDessert(scanner);
            }
        }
        return lunchBuilder.build();
    }

    private void getCourse(Scanner scanner, CuisineItem cuisineItem) {
        int input = -1;
        boolean isExit = false;
        do {
            int count = 1;
            try {
                System.out.println("What course do you prefer? ");
                switch (cuisineItem) {
                    case ITALIAN -> {
                        for (ItalianCourse italianCourse : ItalianCourse.values()) {
                            System.out.println(count + " - Add " + italianCourse);
                            count++;
                        }
                    }
                    case MEXICAN -> {
                        for (MexicanCourse mexicanCourse : MexicanCourse.values()) {
                            System.out.println(count + " - Add " + mexicanCourse);
                            count++;
                        }
                    }
                    case POLISH -> {
                        for (PolishCourse polishCourse : PolishCourse.values()) {
                            System.out.println(count + " - Add " + polishCourse);
                            count++;
                        }
                    }
                }
                input = getUserInput(scanner, count);
                isExit = true;
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED + "!!!Wrong input.Try again!!!" + ANSI_RESET);
                scanner.nextLine();
            }
        } while (!isExit);
        getCourseItem(cuisineItem, input);
    }

    private void getCourseItem(CuisineItem cuisineItem, int input) {
        switch (cuisineItem) {
            case ITALIAN -> {
                switch (input) {
                    case 1 -> lunchBuilder.course(ItalianCourse.FISH);
                    case 2 -> lunchBuilder.course(ItalianCourse.PASTA);
                    case 3 -> lunchBuilder.course(ItalianCourse.MEAT);
                }
            }
            case MEXICAN -> {
                switch (input) {
                    case 1 -> lunchBuilder.course(MexicanCourse.TACOS);
                    case 2 -> lunchBuilder.course(MexicanCourse.TOSTADA);
                    case 3 -> lunchBuilder.course(MexicanCourse.BARBACOA);
                }
            }
            case POLISH -> {
                switch (input) {
                    case 1 -> lunchBuilder.course(PolishCourse.KARTOFLANKA);
                    case 2 -> lunchBuilder.course(PolishCourse.GOLONKA);
                    case 3 -> lunchBuilder.course(PolishCourse.ROLADKI);
                }
            }
        }
    }

    private void getDessert(Scanner scanner) {
        int input = -1;
        boolean isExit = false;
        do {
            int count = 1;
            try {
                System.out.println("What do you prefer for desert?");
                for (DessertItem dessertItem : DessertItem.values()) {
                    System.out.println(count + " - Order " + dessertItem);
                    count++;
                }
                input = getUserInput(scanner, count);
                isExit = true;
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED + "!!!Wrong input.Try again!!!" + ANSI_RESET);
                scanner.nextLine();
            }
        } while (!isExit);
        switch (input) {
            case 1 -> lunchBuilder.dessert(DessertItem.ICE_CREAM);
            case 2 -> lunchBuilder.dessert(DessertItem.CHOCOLATE_FONDANT);
            case 3 -> lunchBuilder.dessert(DessertItem.PANCAKE);
        }
    }

    private int getUserInput(Scanner scanner, int count) {
        int input;
        while (true) {
            System.out.print(CHOICE);
            input = scanner.nextInt();
            if (input >= 1 && input <= count - 1) {
                return input;
            } else {
                System.out.println(ANSI_RED + "!!!No such menu item.Try again!!!" + ANSI_RESET);
                scanner.nextLine();
            }
        }
    }
}
