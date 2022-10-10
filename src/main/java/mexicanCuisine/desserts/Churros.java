package mexicanCuisine.desserts;

import MenuPositionInterface.Dessert;

public class Churros extends Dessert {

    String name = "churros in chocolate";
    double price = 3.90;

    public Churros() {
    }

    public Churros(String name, double price) {
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
