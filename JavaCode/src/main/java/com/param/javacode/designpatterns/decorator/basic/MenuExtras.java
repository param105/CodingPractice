package com.param.javacode.designpatterns.decorator.basic;

/***
 * this is decorator class
 */
abstract class MenuExtras implements MenuItem {

    private MenuItem menuItem ;

    MenuExtras(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String getName() {
        return menuItem.getName();
    }

    @Override
    public double getCost() {
        return menuItem.getCost();
    }
}
