package com.param.javacode.stringprograms;

public class StringPrograms {

    public static void main(String[] args) {

        isStringPalindrome();
        reverseEachWord();
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
