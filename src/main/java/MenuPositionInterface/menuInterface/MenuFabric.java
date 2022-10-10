package MenuPositionInterface.menuInterface;

import MenuPositionInterface.Dessert;
import MenuPositionInterface.Dish;
import MenuPositionInterface.Drink;

import java.util.ArrayList;

public interface MenuFabric {


    ArrayList<MenuPosition> getDishes();

    ArrayList<MenuPosition> getDesserts();

    ArrayList<MenuPosition> getDrinks();


}
