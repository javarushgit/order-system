package com.taslitsky.order;

import com.taslitsky.drink.Drink;
import com.taslitsky.lunch.Lunch;

public class OrderBuilder {
    Order order = new Order();

    public void lunch(Lunch lunch) {
        order.setLunchOrder(lunch);
    }

    public void drink(Drink drink) {
        order.setDrinkOrder(drink);
    }

    public Order build() {
        float sum = 0.0F;
        for (Lunch lunch : order.getLunchOrder()) {
            sum += lunch.getCourseItem().getPrice()
                    + lunch.getDessertItem().getPrice();
        }
        for (Drink drink : order.getDrinkOrder()) {
            sum += drink.getDrinkItem().getPrice();
        }
        order.setSum(sum);
        return order;
    }
}
