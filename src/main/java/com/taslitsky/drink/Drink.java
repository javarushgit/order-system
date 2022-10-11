package com.taslitsky.drink;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Drink {
    private DrinkItem drinkItem;
    private List<DrinkAdditionalItem> drinkAdditionalItems = new ArrayList<>();

    public DrinkItem getDrinkItem() {
        return drinkItem;
    }

    public void setDrinkItem(DrinkItem drinkItem) {
        this.drinkItem = drinkItem;
    }

    public List<DrinkAdditionalItem> getDrinkAdditionalItems() {
        return drinkAdditionalItems;
    }

    public void setDrinkAdditionalItems(List<DrinkAdditionalItem> drinkAdditionalItems) {
        this.drinkAdditionalItems = drinkAdditionalItems;
    }

    @Override
    public String toString() {
        return "\nYou ordered : " + "\n" + getDrinkItem().getName()
                + "-> price: " + getDrinkItem().getPrice() + " usd"
                + "\nwith: " + getDrinkAdditionalItems()
                .stream()
                .map(Enum::toString)
                .collect(Collectors.joining(", ")) + "\n";
    }

}
