package com.taslitsky.lunch;

public class LunchBuilder {
  private Lunch lunch = new Lunch();

  public LunchBuilder course(CourseItem courseItem) {
    lunch.setCourseItem(courseItem);
    return this;
  }
  public LunchBuilder dessert(DessertItem dessertItem) {
    lunch.setDessertItem(dessertItem);
    return this;
  }
  public Lunch build() {
    return lunch;
  }
}
