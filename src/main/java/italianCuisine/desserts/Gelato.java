package italianCuisine.desserts;

import MenuPositionInterface.Dessert;

public class Gelato extends Dessert {


    String name = "gelato with gorgonzola";
    double price = 12.40;

    public Gelato() {
    }

    public Gelato(String name, double price) {
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
