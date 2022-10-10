package handler;

import MenuPositionInterface.Drink;
import MenuPositionInterface.menuInterface.MenuFabric;
import MenuPositionInterface.menuInterface.MenuPosition;
import italianCuisine.MenuItalia;
import mexicanCuisine.MenuMexica;
import polishCuisine.MenuPolish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OrderHandler {
    public Basket basket = new Basket();
    MenuFabric menuFabric;


    public String readConsole() {
	BufferedReader br = null;
	String input = null;
	try {
	    br = new BufferedReader(new InputStreamReader(System.in));
	    input = br.readLine();
	} catch (Exception e) {
	    e.printStackTrace();
		}

	return input;
    }

    public MenuFabric kitchenSelection(int input) {
	switch (input) {
	    case 1:
		return menuFabric = new MenuPolish();

	    case 2:
		return menuFabric = new MenuMexica();

	    case 3:
		return menuFabric = new MenuItalia();


	}
	return null;
    }

    public void menuPositionShow(ArrayList<MenuPosition> menuPositions) {
	int i = 1;
	for (MenuPosition position : menuPositions) {
	    String string = position.getName();
	    double prise= position.getPrice();
	    System.out.println(i + " - " + string + " - "+prise+ "  euro");
	    i++;
	}
    }

    public void addBasket(MenuPosition position) {
	basket.createBasket(position);
    }

    public void choosingADrink(ArrayList<MenuPosition> menuPositions) {
	menuPositionShow(menuPositions);
	String tmp = readConsole();
	Drink drink = (Drink) getMenuPosition(tmp, menuPositions);
	System.out.println("do you want to add\n" +
		"ice(1)?\n" +
		"lemon(2)?\n" +
		"lemon+ice(3)?\n" +
		"without additives(0)?");
	int decor = Integer.parseInt(readConsole());
	AddToDrink(drink,decor);
    }

    public void AddToDrink(Drink drink, int decor){
	switch (decor) {
	    case 0:
		addBasket(drink);
		break;
	    case 1:
		drink.plusIce();
		addBasket(drink);
		break;
	    case 2:
		drink.plusLemon();
		addBasket(drink);
		break;
	    case 3:
		drink.plusLemon();
		drink.plusIce();
		addBasket(drink);
	}


    }


    public MenuPosition getMenuPosition(String name, ArrayList<MenuPosition> menuPositions) {
	for (MenuPosition position : menuPositions) {
	    if (name.equals(position.getName())) {
		return position;
	    }
	}
	return null;
    }

    public void showBasket() {
	System.out.println("you ordered:");
	ArrayList<MenuPosition> result = basket.getOrder();
	for (MenuPosition position : result) {
	    System.out.println(position.getName());
	}
	System.out.println("total amount:     " + basket.getAmaunt());
    }

}
