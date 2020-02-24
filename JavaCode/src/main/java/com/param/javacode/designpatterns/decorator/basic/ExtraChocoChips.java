package com.param.javacode.designpatterns.decorator.basic;

public class ExtraChocoChips extends MenuExtras {

    String menuName = " + Choco Chips";
    double menuCost = 30.00;

    ExtraChocoChips(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getName() {
        return super.getName()+ menuName;
    }

    @Override
    public double getCost() {
        return super.getCost() + menuCost;
    }
}
