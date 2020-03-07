package com.param.javacode.generics;

public class WildCardTest {

    public static void main(String[] args) {

        TwoD twoDs[] = {new TwoD(2,2),new TwoD(22,22)};
        ThreeD threeDs[] = {new ThreeD(3,3,3),new ThreeD(33,33,33)};
        FourD fourDs[] = {new FourD(4,4,4,4),new FourD(44,44,44,44)};

        Cordinates<TwoD> twoDCordinates = new Cordinates<>(twoDs);
        Cordinates<ThreeD> threeDCordinates = new Cordinates<>(threeDs);
        Cordinates<FourD> fourDCordinates = new Cordinates<>(fourDs);

        WildCardTest.showXY(twoDCordinates);
        WildCardTest.showXY(threeDCordinates);
        WildCardTest.showXY(fourDCordinates);

        //WildCardTest.showXYZ(twoDCordinates); // Compile time error
        WildCardTest.showXYZ(threeDCordinates);
        WildCardTest.showXYZ(fourDCordinates);

        //WildCardTest.showAll(twoDCordinates); //// Compile time error
        //WildCardTest.showAll(threeDCordinates); //// Compile time error
        WildCardTest.showAll(fourDCordinates);

    }

    static void showXY(Cordinates<?> c){
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.cords.length ; i++) {
            System.out.println(c.cords[i].x + ", " + c.cords[i].y);
        }
    }

    static void showXYZ(Cordinates<? extends ThreeD> c){
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.cords.length ; i++) {
            System.out.println(c.cords[i].x + ", " + c.cords[i].y +", "+ c.cords[i].z);
        }
    }

    static void showAll(Cordinates<? extends FourD> c){
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.cords.length ; i++) {
            System.out.println(c.cords[i].x + ", " + c.cords[i].y + ", "+ c.cords[i].z +", "+ c.cords[i].t);
        }
    }

}

/**
 * Two dimensional class
 */
class TwoD{
     int x,y;
    TwoD(int a,int b){
        x = a;
        y = b;
    }
}

/***
 * Three dimensional class
 */
class ThreeD extends TwoD{
    int z ;
    ThreeD(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

/***
 * Four dimensional
 */
class FourD extends ThreeD{
    int t;
    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

/***
 * Bounded wildcard coordinates class
 * @param <T>
 */
class Cordinates<T extends TwoD>{
    T[] cords;
    Cordinates(T[] array){
        cords = array;
    }
}
