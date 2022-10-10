package handler;

import MenuPositionInterface.Drink;
import MenuPositionInterface.menuInterface.MenuPosition;
import italianCuisine.MenuItalia;
import italianCuisine.desserts.Gelato;
import italianCuisine.dishes.Pizza;
import italianCuisine.drinks.Chinotto;
import mexicanCuisine.MenuMexica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import polishCuisine.MenuPolish;

import java.util.ArrayList;

class OrderHandlerTest {

    OrderHandler orderHandler=new OrderHandler();




    @Test
    public void shouldCheckOutTheSelectionOfPolishCuisine() {
      ArrayList<MenuPosition> expected=new MenuPolish().getDishes();
      var actual=orderHandler.kitchenSelection(1).getDishes();
        Assertions.assertEquals(expected.get(0).getName(), actual.get(0).getName());
        Assertions.assertTrue(expected.size()==actual.size());
    }

    @Test
    public void shouldCheckOutTheSelectionOfMexicanCuisine() {
        ArrayList<MenuPosition> expected=new MenuMexica().getDishes();
        var actual=orderHandler.kitchenSelection(2).getDishes();
        Assertions.assertEquals(expected.get(0).getName(), actual.get(0).getName());
        Assertions.assertTrue(expected.size()==actual.size());
    }

    @Test
    public void shouldCheckOutTheSelectionOfItalianCuisine() {
        ArrayList<MenuPosition> expected=new MenuItalia().getDishes();
        var actual=orderHandler.kitchenSelection(3).getDishes();
        Assertions.assertEquals(expected.get(0).getName(), actual.get(0).getName());
        Assertions.assertTrue(expected.size()==actual.size());
    }

    @Test
    public void shouldAddToDrinkTest() {
        String expected="sangrita  plus Lemon  plus Ice";
        Drink drink= (Drink) new MenuMexica().getDrinks().get(0);
       orderHandler.AddToDrink(drink,3);
       String actual=orderHandler.basket.getOrder().get(0).getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMenuPositionTest() {
        ArrayList<MenuPosition> polishExpected=new MenuPolish().getDishes();
        String expected="bigos-staropolski";
        ArrayList<MenuPosition> polishActual=orderHandler.kitchenSelection(1).getDishes();
        String actual=polishActual.get(0).getName();
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(polishExpected.size()==polishActual.size());
          }

    @Test
    public void shouldAddBasketTest() {
     double expected = 30.40;
     int expectedSize=3;
     orderHandler.addBasket(new Gelato());
     orderHandler.addBasket(new Chinotto());
     orderHandler.addBasket(new Pizza());
     double actual=orderHandler.basket.getAmaunt();
        int actualSize=orderHandler.basket.order.size();
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(expectedSize==actualSize);
    }
}