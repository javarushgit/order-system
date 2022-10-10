package italianCuisine.drinks;

import MenuPositionInterface.Drink;

public class Chinotto extends Drink {

    String name = "chinotto";
    double price = 3.00;

    public Chinotto() {
    }

    public Chinotto(String name, double price) {
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

    @Override
    public void plusIce() {
	name = name + "  plus Ice";
    }

    @Override
    public void plusLemon() {
	name = name + "  plus Lemon";
    }

}
