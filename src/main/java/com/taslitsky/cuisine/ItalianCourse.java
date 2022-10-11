package com.taslitsky.cuisine;


public enum ItalianCourse implements CourseItem{
    FISH(10F),
    PASTA(12F),
    MEAT(20F);

    private final Float price;

    ItalianCourse(Float price) {
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
