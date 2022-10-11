package com.taslitsky.lunch;
import com.taslitsky.item.Item;

public enum CuisineItem implements Item {
    ITALIAN,
    MEXICAN,
    POLISH;

    @Override
    public String getName() {
        return name();
    }
}
