package com.taslitsky.drink;

import com.taslitsky.item.Item;

public enum DrinkAdditionalItem implements Item {
    LEMON,
    ICE_CUBES,
    NOTHING;

    @Override
    public String getName() {
        return name();
    }
}
