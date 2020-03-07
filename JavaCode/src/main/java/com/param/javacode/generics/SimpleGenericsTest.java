package com.param.javacode.generics;

class SimpleGenericsTest<T,E> {

    private T obj1;
    private E obj2;

    SimpleGenericsTest(T obj, E obj2){
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
        SimpleGenericsTest<Integer,Integer> intObj = new SimpleGenericsTest<>(111,222);
        System.out.println("values in "+ intObj.getType() +" object are :"+ intObj.getObj1() +","+ intObj.getObj2());

        SimpleGenericsTest<String,String> stringObj = new SimpleGenericsTest<>("Param","Chavan");
        System.out.println("values in "+ stringObj.getType() +" object are :"+ stringObj.getObj1() +","+ stringObj.getObj2());

    }
}