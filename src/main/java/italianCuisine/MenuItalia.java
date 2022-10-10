package italianCuisine;

import MenuPositionInterface.Dessert;
import MenuPositionInterface.Dish;
import MenuPositionInterface.Drink;
import MenuPositionInterface.menuInterface.MenuFabric;
import MenuPositionInterface.menuInterface.MenuPosition;
import italianCuisine.desserts.Gelato;
import italianCuisine.dishes.Pizza;
import italianCuisine.drinks.Chinotto;

import java.util.ArrayList;

public class MenuItalia implements MenuFabric {
    ArrayList<MenuPosition> dishes = new ArrayList<>();
    ArrayList<MenuPosition> desserts = new ArrayList<>();
    ArrayList<MenuPosition> drinks = new ArrayList<>();


    @Override
    public ArrayList<MenuPosition> getDishes() {
	dishes.add(new Pizza());
	return dishes;
    }

    @Override
    public ArrayList<MenuPosition> getDesserts() {
	desserts.add(new Gelato());
	return desserts;
    }

    @Override
    public ArrayList<MenuPosition> getDrinks() {
	drinks.add(new Chinotto());
	return drinks;
    }

}
