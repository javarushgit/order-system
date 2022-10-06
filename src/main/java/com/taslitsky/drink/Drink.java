package com.taslitsky.drink;

import java.util.ArrayList;
import java.util.List;

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

  public void setDrinkAdditionalItems(
      List<DrinkAdditionalItem> drinkAdditionalItems) {
    this.drinkAdditionalItems = drinkAdditionalItems;
  }
}
