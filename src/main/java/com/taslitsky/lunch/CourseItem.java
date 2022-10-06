package com.taslitsky.lunch;

import com.taslitsky.item.PaidItem;

public enum CourseItem implements PaidItem {
  FISH(10F),
  PASTA(11.5F),
  MEAT(20F);

  private final Float price;

  CourseItem(Float price) {
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
