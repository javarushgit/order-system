import MenuPositionInterface.menuInterface.MenuFabric;
import MenuPositionInterface.menuInterface.MenuPosition;
import handler.OrderHandler;
import italianCuisine.MenuItalia;
import mexicanCuisine.MenuMexica;
import polishCuisine.MenuPolish;

import java.util.ArrayList;

public class AcceptingOrders {
    static OrderHandler orderHandler = new OrderHandler();

    public static void main(String[] args) {

	ArrayList<MenuPosition> menuPositions;
	MenuFabric menuFabric = null;
	showMenu("Polish",new MenuPolish());
	showMenu("Mexican",new MenuMexica());
	showMenu("Italian",new MenuItalia());
	menuFabric = selection();
	System.out.println("choose a dish from the assortment, enter a name");
	menuPositions = menuFabric.getDishes();
	orderHandler.menuPositionShow(menuPositions);
	String input = orderHandler.readConsole();
	MenuPosition purchase = orderHandler.getMenuPosition(input, menuPositions);
	orderHandler.addBasket(purchase);
	menuFabric = kitchenChange(menuFabric);
	System.out.println("choose a dessert from the assortment, enter a name");
	menuPositions = menuFabric.getDesserts();
	orderHandler.menuPositionShow(menuPositions);
	input = orderHandler.readConsole();
	purchase = orderHandler.getMenuPosition(input, menuPositions);
	orderHandler.addBasket(purchase);
	System.out.println("do you want to choose a drink ?\n" +
		"y/n");
	input = orderHandler.readConsole();
	switch (input) {
	    case "n":
		orderHandler.showBasket();
		break;
	    case "y":
		menuFabric = kitchenChange(menuFabric);
		System.out.println("choose a drink from the assortment, enter a name");
		orderHandler.choosingADrink(menuFabric.getDrinks());
		orderHandler.showBasket();
		break;
	}

    }

    private static MenuFabric selection() {
	System.out.println("user's choice Polish cuisine -enter 1; Mexican cuisine -enter 2; Italian cuisine - enter 3;");
	int console= Integer.parseInt(orderHandler.readConsole());
	return orderHandler.kitchenSelection(console);
    }

    private static MenuFabric kitchenChange(MenuFabric menuFabric) {
	System.out.println("do you want to change the kitchen?\n" +
		"y/n");
	String input = orderHandler.readConsole();
	switch (input) {
	    case "y":
		return selection();
	}
	return menuFabric;
    }

    private static void showMenu(String cantry, MenuFabric menuFabric){
	System.out.println("                         \n");
	System.out.println("menu "+cantry+ " cuisine");
	orderHandler.menuPositionShow(menuFabric.getDishes());
	orderHandler.menuPositionShow(menuFabric.getDesserts());
	orderHandler.menuPositionShow(menuFabric.getDrinks());
    }
}

