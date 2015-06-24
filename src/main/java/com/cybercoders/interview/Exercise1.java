package com.cybercoders.interview;

/**
 * Houses the code for Coding Interview Exercise 1: Reversing a String.
 */
public class Exercise1 {
    /**
     * Reverses a string by first reading it into a Char Array, rather than successively calling
     * {@link String#charAt(int)}, and I use a StringBuilder.
     *
     * @param stringToReverse the string to reverse
     * @return the reversed string or, if the input parameter was null, a blank string
     */
    public static String reverseString(String stringToReverse) {
        if (!(stringToReverse == null && "".equals(stringToReverse))) {
            StringBuilder reversedString = new StringBuilder();

            char[] stringAsCharArray = stringToReverse.toCharArray();
            for (int i = stringAsCharArray.length - 1; i >= 0; i--) {
                reversedString.append(stringAsCharArray[i]);
            }

            return reversedString.toString();
        }

        return "";
    }
}