package com.kdvamja.java8demos.ep1;

/*
* JAVA 8 NEW FEATURES
*
*
    1.	lambda expression
    2.	function interface
    3.	default method in interface
    4.	static methods in interface
    5. 	PREDICATE / FUNCTION / CONSUMER pre defined functional interfaces
    6.	method refrence & constructor reference by double colon (::) operator
    7.	Stream API - mostly important used in collection
    8.	New Date and Time API (joda api)

    to simplify programming
    to use functional programming benifites in java
    to enable parralal processing in java
* */

import java.util.ArrayList;
import java.util.List;

/*
* # What is lambda Expression.
* =>    It is anonymous function (not having name, modifier and return types)
* =>    Note:: lambda Expression can only used to implements functional interfaces.
* =>    Note:: If lambda expression return anything then we don't need to write return keyword into it.
* */
public class ApplicationEp1 {

    private static MathematicalOp multiply = (int x, int y) -> x * y; // write code of the method using lambda expression
    private static MathematicalOp sum = (int x, int y) -> x + y;
    private static MathematicalOp substract = (int x, int y) -> x - y;

    private static int oprator(int x, int y, MathematicalOp obj){
        return obj.operation(x,y);
    }

    private static int sum(int x, int y){
        return x+y;
    }

    public static void printTitle(String str){
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println(str);
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void main(String arg[]){
        ApplicationEp1.printTitle("Multiply 2 number using tradesional way by creating static method for it");
        System.out.println(ApplicationEp1.sum(5,7));

        ApplicationEp1.printTitle("Simple List and add 3 values into it and print it using method reffrence");
        List<Integer> arrList = new ArrayList<>();
        arrList.add(3);
        arrList.add(6);
        arrList.add(9);
        //arrList.forEach(i -> System.out.println(i));
        arrList.forEach(System.out::println);

        List<Integer> arrList1 = List.of(1,2,3,4,5,6,7,8,9,10);
        ApplicationEp1.printTitle("Simple List through the forEach");
        //arrList1.forEach(i-> { if(i%2 == 0){System.out.println(i);}});

        arrList1.stream() // using stream Api
                .filter(i->i%2 == 0) // filter the values using stream api filter method
                .forEach(System.out::println); // print the values by using method reffrence

        ApplicationEp1.printTitle("Mathematical Operations for Multiply");
        arrList1.forEach(i-> { if(i%2 == 0){System.out.println(i+"*"+"2 = "+ApplicationEp1.oprator(i,2,multiply));}});
        ApplicationEp1.printTitle("Mathematical Operations for Sum");
        arrList1.forEach(i-> { if(i%2 == 0){System.out.println(i+"+"+"2 = "+ApplicationEp1.oprator(i,2,sum));}});
        ApplicationEp1.printTitle("Mathematical Operations for Substract");
        arrList1.forEach(i-> { if(i%2 == 0){System.out.println(i+"-"+"2 = "+ApplicationEp1.oprator(i,1,substract));}});
    }


    // OUTPUT

    /*
        -----------------------------------------------------------------------------
        Multiply 2 number using tradesional way by creating static method for it
        -----------------------------------------------------------------------------
        12

        -----------------------------------------------------------------------------
        Simple List and add 3 values into it and print it using method reffrence
        -----------------------------------------------------------------------------
        3
        6
        9

        -----------------------------------------------------------------------------
        Simple List through the forEach
        -----------------------------------------------------------------------------
        2
        4
        6
        8
        10

        -----------------------------------------------------------------------------
        Mathematical Operations for Multiply
        -----------------------------------------------------------------------------
        2*2 = 4
        4*2 = 8
        6*2 = 12
        8*2 = 16
        10*2 = 20

        -----------------------------------------------------------------------------
        Mathematical Operations for Sum
        -----------------------------------------------------------------------------
        2+2 = 4
        4+2 = 6
        6+2 = 8
        8+2 = 10
        10+2 = 12

        -----------------------------------------------------------------------------
        Mathematical Operations for Substract
        -----------------------------------------------------------------------------
        2-2 = 1
        4-2 = 3
        6-2 = 5
        8-2 = 7
        10-2 = 9
    */
}
