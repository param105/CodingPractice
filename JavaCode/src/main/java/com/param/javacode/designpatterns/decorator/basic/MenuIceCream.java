package com.param.javacode.designpatterns.decorator.basic;

class MenuIceCream implements MenuItem {

    private String menuName = " Ice Cream";
    private double menuCost = 100.00;

    @Override
    public String getName() {
        return menuName;
    }

    @Override
    public double getCost() {
        return menuCost;
    }
}
