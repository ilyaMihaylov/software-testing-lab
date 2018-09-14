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
                Messages.printResult(firstNumber, secondNumber, Operations.add(firstNumber,secondNumber), "+");
                break;
            case "-":
                Messages.printResult(firstNumber, secondNumber, Operations.subtract(firstNumber,secondNumber), "-");
                break;
            case "*":
                Messages.printResult(firstNumber, secondNumber, Operations.multiply(firstNumber,secondNumber), "*");
                break;
            case "/":
                Messages.printResult(firstNumber, secondNumber, Operations.divide(firstNumber,secondNumber), "/");
                break;
            default:
                System.out.println("Illegal Operation");
        }
    }
}