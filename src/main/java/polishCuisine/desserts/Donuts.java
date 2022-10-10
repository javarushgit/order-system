package polishCuisine.desserts;

import MenuPositionInterface.Dessert;

public class Donuts extends Dessert {

    String name = "donuts with powdered sugar";
    double price = 7.80;

    public Donuts() {
    }

    public Donuts(String name, double price) {
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
