package com.param.javacode.basicprograms;

import java.util.HashMap;

public class BasicPrograms {
    private static int[] intArray = {0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,100};
    private static char[] charArray = {'p','a','r','m','e','s','h','w','a','r','c','h','a','v','a','n'};

    public static void main(String[] args) {
        System.out.println("### Check string as palindrome >>>> ");
        isStringPalindrome();//check if String is palindrome or not
        System.out.println( "\n-------------------------------------------");

        System.out.println("### Find letters count form the array >>>> ");
        findLettersCount(); // find letter count
        System.out.println( "\n-------------------------------------------");

        System.out.println("### Find odd numbers without for loop >>>> ");
        findOddNumbersFromArray(intArray,0); // find odd numbers
        System.out.println( "\n-------------------------------------------");


        System.out.println("### Reverse each word from the string >>>> ");
        reverseEachWordFromSentence(); // reverse each word from sentence
        System.out.println( "\n-------------------------------------------");

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

    /***
     * find each letters count from the string or array.
     */
    private static void findLettersCount() {
        HashMap<Character,Integer> letterCoutMap = new HashMap<>();
        for (Character c: charArray) {
            if (letterCoutMap.containsKey(c)) {
                letterCoutMap.put(c, letterCoutMap.get(c) + 1);
            } else {
                letterCoutMap.put(c, 1);
            }
        }
        for (Character c: letterCoutMap.keySet()) {
            System.out.println( c +" -> "+ letterCoutMap.get(c));
        }

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
     * Sentense - Hello World
     * ans - olleH dlroW
     */
    private static void reverseEachWordFromSentence() {
        String str = "I am Android Engineer.";
        StringBuilder sb = new StringBuilder();

        for (char c: str.toCharArray()) {
            if(c == ' ' || c == '.'){
                for (int i = sb.length()-1; i >=0 ; i--) {
                    System.out.print(sb.charAt(i));
                }
                System.out.println(" ");
                sb.delete(0,sb.length());
            }else{
                sb.append(c);
            }
        }
        System.out.println(" ");

    }

}
