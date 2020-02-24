package com.param.javacode.designpatterns.decorator.basic;


public class ExtraHoney extends MenuExtras {

    String menuName = " + Honey";
    double menuCost = 50.00;

    public ExtraHoney(MenuItem menuItem) {
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
