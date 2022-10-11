package com.taslitsky;
import com.taslitsky.cuisine.MexicanCourse;
import com.taslitsky.drink.Drink;
import com.taslitsky.drink.DrinkAdditionalItem;
import com.taslitsky.drink.DrinkBuilder;
import com.taslitsky.drink.DrinkItem;
import com.taslitsky.lunch.CuisineItem;
import com.taslitsky.lunch.DessertItem;
import com.taslitsky.lunch.Lunch;
import com.taslitsky.lunch.LunchBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


public class MyOrderSystemTest {

    @Test
    public void lunchCreateTest() {
        //GIVEN
        Lunch lunch;
        LunchBuilder lunchBuilder = new LunchBuilder();
        lunch = lunchBuilder.cuisine(CuisineItem.MEXICAN)
                .course(MexicanCourse.BARBACOA)
                .dessert(DessertItem.PANCAKE)
                .build();
        String expectedCuisineItem = "MEXICAN";
        String expectedCourseItem = "BARBACOA";
        String expectedDessertItem = "PANCAKE";
        //WHEN
        String actualCuisineItem = lunch.getCuisineItem().getName();
        String actualCourseItem = lunch.getCourseItem().getName();
        String actualDessertItem = lunch.getDessertItem().getName();
        //THEN
        Assertions.assertNotNull(lunch);
        Assertions.assertEquals(expectedCuisineItem, actualCuisineItem);
        Assertions.assertEquals(expectedCourseItem, actualCourseItem);
        Assertions.assertEquals(expectedDessertItem, actualDessertItem);
    }

    @Test
    public void drinkCreateTest() {
        //GIVEN
        Drink drink;
        DrinkBuilder drinkBuilder = new DrinkBuilder();
        drink = drinkBuilder.drink(DrinkItem.PEPSI)
                .additionalItem(List.of(DrinkAdditionalItem.LEMON, DrinkAdditionalItem.ICE_CUBES))
                .build();
        String expectedDrinkItem = "PEPSI";
        List<DrinkAdditionalItem> expectedAdditionalItemList;
        List<DrinkAdditionalItem> actualAdditionalItemList;
        expectedAdditionalItemList = List.of(DrinkAdditionalItem.LEMON, DrinkAdditionalItem.ICE_CUBES);
        //WHEN
        String actualDrinkItem = drink.getDrinkItem().getName();
        actualAdditionalItemList = drink.getDrinkAdditionalItems();
        //THEN
        Assertions.assertNotNull(drink);
        Assertions.assertEquals(expectedDrinkItem, actualDrinkItem);
        Assertions.assertEquals(expectedAdditionalItemList, actualAdditionalItemList);
    }
}
