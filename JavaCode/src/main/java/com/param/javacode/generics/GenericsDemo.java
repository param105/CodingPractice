package com.param.javacode.generics;

class GenericsDemo<T,E> {

    private T obj1;
    private E obj2;

    GenericsDemo(T obj, E obj2){
        this.obj1 = obj;
        this.obj2 = obj2;
    }

    T getObj1(){
        return obj1;
    }

    E getObj2(){
        return obj2;
    }

    String getType(){
        return obj1.getClass().getSimpleName();
    }

}

class MainClass{
    public static void main(String[] args) {
        GenericsDemo<Integer,Integer> intObj = new GenericsDemo<>(111,222);
        System.out.println("values in "+ intObj.getType() +" object are :"+ intObj.getObj1() +","+ intObj.getObj2());

        GenericsDemo<String,String> stringObj = new GenericsDemo<>("Param","Chavan");
        System.out.println("values in "+ stringObj.getType() +" object are :"+ stringObj.getObj1() +","+ stringObj.getObj2());

    }
}