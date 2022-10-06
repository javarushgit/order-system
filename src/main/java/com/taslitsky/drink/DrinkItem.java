package com.taslitsky.drink;

import com.taslitsky.item.PaidItem;

public enum DrinkItem implements PaidItem {
  PEPSI(5F),
  COLA(4F),
  WINE(8F),
  STELLA_ARTOIS(5F);

  private final Float price;

  DrinkItem(Float price) {
    this.price = price;
  }


  @Override
  public String getName() {
    return name();
  }

  @Override
  public Float getPrice() {
    return price;
  }
}
