package mexicanCuisine;

import MenuPositionInterface.Dessert;
import MenuPositionInterface.Dish;
import MenuPositionInterface.Drink;
import MenuPositionInterface.menuInterface.MenuFabric;
import MenuPositionInterface.menuInterface.MenuPosition;
import italianCuisine.desserts.Gelato;
import italianCuisine.dishes.Pizza;
import italianCuisine.drinks.Chinotto;
import mexicanCuisine.desserts.Churros;
import mexicanCuisine.dishes.Enchilada;
import mexicanCuisine.drinks.Sangrita;

import java.util.ArrayList;

public class MenuMexica implements MenuFabric {

    ArrayList<MenuPosition> dishes = new ArrayList<>();
    ArrayList<MenuPosition> desserts = new ArrayList<>();
    ArrayList<MenuPosition> drinks = new ArrayList<>();


    @Override
    public ArrayList<MenuPosition> getDishes() {
	dishes.add(new Enchilada());
	return dishes;
    }

    @Override
    public ArrayList<MenuPosition> getDesserts() {
	desserts.add(new Churros());
	return desserts;
    }

    @Override
    public ArrayList<MenuPosition> getDrinks() {
	drinks.add(new Sangrita());
	return drinks;
    }



}
