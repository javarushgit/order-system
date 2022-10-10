package MenuPositionInterface;

import MenuPositionInterface.menuInterface.DrinkDecorator;
import MenuPositionInterface.menuInterface.MenuPosition;

public class Drink extends MenuPosition implements DrinkDecorator {

    String name;
    double price;


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
