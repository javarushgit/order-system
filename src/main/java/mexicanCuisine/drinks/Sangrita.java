package mexicanCuisine.drinks;

import MenuPositionInterface.Drink;

public class Sangrita extends Drink {

    String name = "sangrita";
    double price = 4.00;

    public Sangrita() {
    }

    public Sangrita(String name, double price) {
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
