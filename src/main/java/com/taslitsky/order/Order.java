package com.taslitsky.order;

import com.taslitsky.drink.Drink;
import com.taslitsky.lunch.Lunch;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Lunch> lunchOrder = new ArrayList<>();
    private final List<Drink> drinkOrder = new ArrayList<>();
    private float sum;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void setLunchOrder(Lunch lunch) {lunchOrder.add(lunch);}

    public void setDrinkOrder(Drink drink) {drinkOrder.add(drink);}

    public void setSum(float sum) {
        this.sum = sum;
    }

    public List<Lunch> getLunchOrder() {
        return lunchOrder;
    }

    public List<Drink> getDrinkOrder() {
        return drinkOrder;
    }

    public float getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return ANSI_GREEN + "You ordered:\n" + lunchOrder.toString().replace("[", "")
                .replace("]", "")
                .replace(", ", "") + ""
                + drinkOrder.toString().replace("[", "")
                .replace("]", "").replace(", ", "")
                + "Total price: " + sum + " usd" + ANSI_RESET;
    }
}
