package com.hackaton.eHealth.utils;

public enum MealType {
    MILK(10),
    POULTRY(10),
    VEAL(10),
    EGG(10),
    LOAF_OF_BREAD(10),
    POTATO(10);

    private int value;

    MealType(int value) {
        this.value=value;
    }

}
