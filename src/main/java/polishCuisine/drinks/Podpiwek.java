package polishCuisine.drinks;

import MenuPositionInterface.Drink;

public class Podpiwek extends Drink {

    String name = "podpiwek";
    double price = 1.50;

    public Podpiwek() {
    }

    public Podpiwek(String name, double price) {
	this.name = name;
	this.price = price;
    }

    @Override
    public void plusIce() {
	name = name + "  plus Ice";
    }

    @Override
    public void plusLemon() {
	name = name + "  plus Lemon";
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
