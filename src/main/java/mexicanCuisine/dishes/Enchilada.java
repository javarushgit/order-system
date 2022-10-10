package mexicanCuisine.dishes;

import MenuPositionInterface.Dish;

public class Enchilada extends Dish {

    String name = "enchilada";
    double price = 8.20;

    public Enchilada() {
    }

    public Enchilada(String name, double price) {
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
