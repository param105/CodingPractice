package com.param.javacode.designpatterns.decorator.basic;

public class MainClass {


    private MainClass() { }

    /***
     * function to create dummy order
     */
    private void createOrder(){
        MenuItem menu = new MenuIceCream();
        menu = new ExtraChocoChips(menu);
        menu = new ExtraHoney(menu);

        System.out.println("Order is   : "+menu.getName());
        System.out.println("Total cost : "+menu.getCost() +"Rs");
    }

    public static void main(String[] args) {
        new MainClass().createOrder();

    }
}
