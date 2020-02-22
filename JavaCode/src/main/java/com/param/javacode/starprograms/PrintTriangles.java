package com.param.javacode.starprograms;

public class PrintTriangles {

    public static void main(String[] args) {

        printNinetyDigreeTriangle(); // print ninety degree triangle
        printNinetyDigreeReverseTriangle();
        printMiddleStarTriangle();// p
        printMiddleStarDownTriangle();
        printArrowStarsPattern();
        printreverseArrowStarsPattern();
    }

    private static void printreverseArrowStarsPattern() {
        int lines = 10;

        for (int row = 1; row <= lines ; row++) {
            for(int pos = 1; pos <= lines ; pos++){
                if(pos <= lines - row)
                    System.out.print("   ");
                else
                    System.out.print(" * ");
            }

            System.out.println();
        }

        for (int row = lines; row >= 0 ; row--) {
            for(int pos = 0; pos < lines ; pos++){
                if(pos <= lines - row)
                    System.out.print("   ");
                else
                    System.out.print(" * ");
            }

            System.out.println();
        }
    }

    /***
     * arraow like pattern printing
     */
    private static void printArrowStarsPattern() {
        int rows = 10;

        for (int row = 1; row <= rows ; row++) {
            for(int pos = 1;pos<=row; pos++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        for (int row = rows; row >= 0 ; row--) {
            for(int pos = 0;pos <= row ; pos++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    /***
     * print triangle reverse
     */
    private static void printMiddleStarDownTriangle() {
        int lines = 10;
        String starWithSpaces = " * ";

        System.out.println();
        System.out.println();

        for(int row = 1;row <= lines; row++){
            printSpaces(row);
            for(int pos = row; pos <= lines+lines-row; pos++  ){
                System.out.print(starWithSpaces);
            }
            System.out.println();
        }

    }

    /***
     * reserve triangle
     */
    private static void printNinetyDigreeReverseTriangle() {
        int lines = 10;

        for (int row = 1; row <= lines ; row++) {
            for(int pos = 1; pos <= lines ; pos++){
                if(pos <= lines - row)
                    System.out.print("   ");
                else
                    System.out.print(" * ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    /***
     * Prints middle star triangle
     */
    private static void printMiddleStarTriangle() {
        int lines = 10;

        String starWithSpaces = " * ";

        for(int row = 0;row < lines; row++){
            printSpaces(lines-row);
            for(int pos = lines-row;pos <= lines+row; pos++  ){
                System.out.print(starWithSpaces);
            }
            System.out.println();
        }


    }

    /***
     * to print empty spaces
     * @param count
     */
    private static void printSpaces(int count) {
        String emptySpaces = "   ";
        for (int j = 0; j < count; j++) {
            System.out.print(emptySpaces);
        }
    }

    /***
     * function to print ninety degree triangle
     */
    private static void printNinetyDigreeTriangle() {
        int rows = 10;

        for (int row = 1; row <= rows ; row++) {
            for(int pos = 1;pos<=row; pos++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


}
