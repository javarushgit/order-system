package polishCuisine.dishes;

import MenuPositionInterface.Dish;

public class BigosStaropolski extends Dish {

    String name = "bigos-staropolski";
    double price = 10.50;

    public BigosStaropolski() {
    }

    public BigosStaropolski(String name, double price) {
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
