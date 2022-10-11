package com.taslitsky.drink;
import java.util.List;

public class DrinkBuilder {
    private final Drink drink = new Drink();

    public DrinkBuilder drink(DrinkItem drinkItem) {
        drink.setDrinkItem(drinkItem);
        return this;
    }

    public DrinkBuilder additionalItem(List<DrinkAdditionalItem> items) {
        drink.setDrinkAdditionalItems(items);
        return this;
    }

    public Drink build() {
        return drink;
    }

}
