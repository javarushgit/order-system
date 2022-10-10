package handler;

import MenuPositionInterface.menuInterface.MenuPosition;

import java.util.ArrayList;

public class Basket {

    ArrayList<MenuPosition> order = new ArrayList<>();

    double amaunt = 0;

    public void createBasket(MenuPosition menuPosition) {

	order.add(menuPosition);
	amaunt = amaunt + menuPosition.getPrice();

    }

    public ArrayList<MenuPosition> getOrder() {
	return order;
    }

    public Double getAmaunt() {
	return amaunt;
    }

    public void setAmaunt(double amaunt) {
	this.amaunt = this.amaunt + amaunt;
    }

}
