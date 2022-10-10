package italianCuisine.dishes;

import MenuPositionInterface.Dish;

public class Pizza extends Dish {

    String name = "pepperoni";
    double price = 15.00;

    public Pizza() {
    }

    public Pizza(String name, double price) {
	this.name = name;
	this.price = price;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Double getPrice() {
	return price;
    }
}
