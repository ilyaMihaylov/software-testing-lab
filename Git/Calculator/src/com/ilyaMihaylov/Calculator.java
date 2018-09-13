package com.ilyaMihaylov;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number:");
        double firstNumber = input.nextDouble();

        System.out.println("Enter second number:");
        double secondNumber = input.nextDouble();

        System.out.println("Select operation: \"+\" for Addition, \"-\" for Subtraction \"*\" for Multiplication and \"/\" for Division:");

        switch (input.next()){
            case "+":
                System.out.println(add(firstNumber,secondNumber));
                break;
            case "-":
                System.out.println(subtract(firstNumber,secondNumber));
                break;
            case "*":
                System.out.println(multiply(firstNumber,secondNumber));
                break;
            case "/":
                System.out.println(divide(firstNumber,secondNumber));
                break;
            default:
                System.out.println("Illegal Operation");
        }
    }

    private static double add(double x, double y) { return x+y; }

    private static double subtract(double x, double y) { return x-y; }

    private static double multiply(double x, double y) { return x*y; }

    private static double divide(double x, double y) { return x/y; }
}