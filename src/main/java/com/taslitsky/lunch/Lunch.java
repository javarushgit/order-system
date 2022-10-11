package com.taslitsky.lunch;
import com.taslitsky.cuisine.CourseItem;

public class Lunch {
    CuisineItem cuisineItem;
    CourseItem courseItem;
    DessertItem dessertItem;

    public CuisineItem getCuisineItem() {
        return cuisineItem;
    }

    public void setCuisineItem(CuisineItem cuisineItem) {
        this.cuisineItem = cuisineItem;
    }

    public void setCourseItem(CourseItem courseItem) {
        this.courseItem = courseItem;
    }

    public CourseItem getCourseItem() {
        return courseItem;
    }

    public DessertItem getDessertItem() {
        return dessertItem;
    }

    public void setDessertItem(DessertItem dessertItem) {
        this.dessertItem = dessertItem;
    }

    @Override
    public String toString() {
        return "\nYou ordered : "
                + "\nFor lunch: \n" + getCuisineItem().getName()
                + " " + getCourseItem().getName()
                + "-> price: " + getCourseItem().getPrice() + " usd"
                + "\nFor desert: \n" + getDessertItem().getName()
                + "-> price: " + getDessertItem().getPrice() + " usd\n";
    }
}
