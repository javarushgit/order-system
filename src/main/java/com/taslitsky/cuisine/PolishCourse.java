package com.taslitsky.cuisine;

import com.taslitsky.item.PaidItem;

public enum PolishCourse implements PaidItem, CourseItem {
    KARTOFLANKA(17F),
    GOLONKA(8F),
    ROLADKI(19F);

    private final Float price;

    PolishCourse(Float price) {
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
