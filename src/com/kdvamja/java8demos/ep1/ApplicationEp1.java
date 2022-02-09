package com.kdvamja.java8demos.ep1;

/*
* # What is lambda Expression.
* =>    It is anonymous function (not having name, modifier and return types)
* */
public class ApplicationEp1 {

    private static int sum(int x, int y){
        return x+y;
    }

    public static void main(String arg[]){
        System.out.println(ApplicationEp1.sum(5,7));

    }
}
