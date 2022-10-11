package com.taslitsky.lunch;
import com.taslitsky.item.PaidItem;

public enum DessertItem implements PaidItem {

    ICE_CREAM(10F),
    CHOCOLATE_FONDANT(11.5F),
    PANCAKE(15F);

    private final Float price;

    DessertItem(Float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public Float getPrice() {
        return price;
    }
}
