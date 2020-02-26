package com.param.javacode.stringprograms;

public class BasicPrograms {
    private static int[] intArray = {0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,100};

    public static void main(String[] args) {
        isStringPalindrome();//check if String is palindrome or not
        reverseEachWord(); // reverse each word from sentence
        findLettersCount(); // find letter count
        findOddNumbersFromArray(intArray,0); // find odd numbers

    }

    /***
     * Find all odd numbers in array
     */
    private static void findOddNumbersFromArray(int[] intArray, int index) {
        if(index < intArray.length ) {
            if (intArray[index] % 2 != 0) {
                System.out.print(" -> " + intArray[index]);
            }
            findOddNumbersFromArray(intArray, ++index);
        }
    }

    /***
     * find each letters count from the string or array.
     */
    private static void findLettersCount() {

    }

    /***
     * Sentense - Hello World
     * ans - olleH dlroW
     */
    private static void reverseEachWord() {

    }

    /***
     * to check if string is palindrome
     */
    private static void isStringPalindrome() {
        String str = "maddam";
        boolean isPalindrome = true;
        int i,j =0;

        for ( i = 0, j= str.length()-1; i <= str.length()/2 && j >=  (str.length())/2 ; i++,j--) {
                if(str.charAt(i) != str.charAt(j)){
                    isPalindrome = false;
                    break;
                }
        }
        if(isPalindrome)
            System.out.println(str+" is palindrome");
        else
            System.out.println(str+" is NOT palindrome");

    }


}
