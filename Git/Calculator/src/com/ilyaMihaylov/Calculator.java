package com.ilyaMihaylov;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Messages.printMessage("Enter first number:");
        double firstNumber = input.nextDouble();

        Messages.printMessage("Enter second number:");
        double secondNumber = input.nextDouble();

        Messages.printMessage("Select operation: \"+\" for Addition, \"-\" for Subtraction \"*\" for Multiplication \"/\" for Division and \"^\" for Exponentiation:");

        switch (input.next()){
            case "+":
                Messages.printResult(firstNumber, secondNumber, Operations.add(firstNumber, secondNumber), "+");
                break;
            case "-":
                Messages.printResult(firstNumber, secondNumber, Operations.subtract(firstNumber, secondNumber), "-");
                break;
            case "*":
                Messages.printResult(firstNumber, secondNumber, Operations.multiply(firstNumber, secondNumber), "*");
                break;
            case "/":
                Messages.printResult(firstNumber, secondNumber, Operations.divide(firstNumber, secondNumber), "/");
                break;
            case "^":
                Messages.printResult(firstNumber, secondNumber, Operations.exponentiation(firstNumber, secondNumber), "^");
                break;
            default:
                System.out.println("Illegal Operation");
        }
    }
}