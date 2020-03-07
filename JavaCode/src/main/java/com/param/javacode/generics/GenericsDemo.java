package com.param.javacode.generics;

/***
 * class showing generics demo with T, E, V as generic values
 * @param <T>
 * @param <E>
 */
class GenericsDemo<T,E> {

    private T obj1;
    private E obj2;
    private double doubleVal;

    /***
     * Generic type parameters
     */
    GenericsDemo(T obj, E obj2){
        this.obj1 = obj;
        this.obj2 = obj2;
    }

    /***
     * Generic constructor can be used even if class is not generic
     */
    <V extends Number> GenericsDemo(V val){
        doubleVal = val.doubleValue();
    }

    T getObj1(){
        return obj1;
    }

    E getObj2(){
        return obj2;
    }

    void showVal(){
        System.out.println("Value : "+ doubleVal);
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

        GenericsDemo doubleGeneric = new GenericsDemo(555);
        doubleGeneric.showVal();
    }
}