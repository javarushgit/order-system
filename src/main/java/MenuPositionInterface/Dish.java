package MenuPositionInterface;

import MenuPositionInterface.menuInterface.MenuPosition;

public class Dish extends MenuPosition {

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
}
