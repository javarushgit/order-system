package polishCuisine;

import MenuPositionInterface.Dessert;
import MenuPositionInterface.Dish;
import MenuPositionInterface.Drink;
import MenuPositionInterface.menuInterface.MenuFabric;
import MenuPositionInterface.menuInterface.MenuPosition;
import polishCuisine.desserts.Donuts;
import polishCuisine.dishes.BigosStaropolski;
import polishCuisine.drinks.Podpiwek;

import java.util.ArrayList;

public class MenuPolish implements MenuFabric {

    ArrayList<MenuPosition> dishes = new ArrayList<>();
    ArrayList<MenuPosition> desserts = new ArrayList<>();
    ArrayList<MenuPosition> drinks = new ArrayList<>();


    @Override
    public ArrayList<MenuPosition> getDishes() {
	dishes.add(new BigosStaropolski());
	return dishes;
    }

    @Override
    public ArrayList<MenuPosition> getDesserts() {
	desserts.add(new Donuts());
	return desserts;
    }

    @Override
    public ArrayList<MenuPosition> getDrinks() {
	drinks.add(new Podpiwek());
	return drinks;
    }



}
