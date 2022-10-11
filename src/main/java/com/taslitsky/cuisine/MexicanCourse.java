package com.taslitsky.cuisine;

import com.taslitsky.item.PaidItem;


public enum MexicanCourse implements PaidItem, CourseItem {
    TACOS(5F),
    TOSTADA(12F),
    BARBACOA(16F);

    private final Float price;

    MexicanCourse(Float price) {
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
