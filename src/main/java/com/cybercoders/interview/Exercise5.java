package com.cybercoders.interview;

import java.util.LinkedList;

public class Exercise5 {
    public static void main(String[] args) {
        String[] someStrings = {"Batman", "Superman", "Wonder Woman", "The Flash", "Aquaman"};
//        String[] someStrings = {"2", "3", "4", "5", "6"};

        System.out.println(func(someStrings, 5));
    }

    public static double func(String a[], int bottom) {
        LinkedList<Double> converted = new LinkedList();
        for (int j = 0; j < a.length; j++)
            converted.add(Double.valueOf(a[j]));
        double b[] = new double[a.length - 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = converted.get(i);
        }
        if (a.length == 1)
            return Double.valueOf(a[0]);
        else {
            Double temp = Double.valueOf(a[a.length - 1]);
            if (temp > b[b.length]) {
                b[b.length - 1] = temp;
            }
        }
        String[] args = new String[b.length];
        for (int k = 0; k < b.length; ++k)
            args[k] = Double.toString(b[k]);
        return func(args, bottom);
    }
}