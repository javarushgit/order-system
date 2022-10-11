package com.taslitsky.lunch;
import com.taslitsky.cuisine.CourseItem;

public class LunchBuilder {
    private final Lunch lunch = new Lunch();

    public LunchBuilder cuisine(CuisineItem cuisineItem) {
        lunch.setCuisineItem(cuisineItem);
        return this;
    }

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

