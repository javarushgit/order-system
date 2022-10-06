package com.taslitsky.drink;

public class DrinkBuilder {
  private Drink drink = new Drink();

  public DrinkBuilder drink(DrinkItem drinkItem) {
    drink.setDrinkItem(drinkItem);
    return this;
  }

  public DrinkBuilder additionalItem(DrinkAdditionalItem item) {
    drink.getDrinkAdditionalItems().add(item);
    return this;
  }

  public Drink build() {
    return drink;
  }
}
