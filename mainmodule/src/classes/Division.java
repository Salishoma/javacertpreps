package classes;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class Division {
    private static final Scanner scanner = new Scanner(System.in);

    // Enum to represent arithmetic operations
    private enum Operation {
        ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/"), MODULUS("%"), DISPLAY_OPTIONS("6"), QUIT("7");

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public static void main(String[] args) {
        arithmeticOperation();
    }

    private static void arithmeticOperation() {
        displayOptions();
        Operation operation;
        do {
            operation = getOperationFromUser();
            performOperation(operation);
        } while (operation != Operation.QUIT);
    }

    private static Operation getOperationFromUser() {
        System.out.println("Enter your choice:");
        String userInput = scanner.nextLine();
        for (Operation op : Operation.values()) {
            if (userInput.equals(op.getSymbol())) {
                return op;
            }
        }
        System.out.println("Invalid input. Please try again.");
        return Operation.DISPLAY_OPTIONS;
    }

    private static void performOperation(Operation operation) {
        switch (operation) {
            case ADDITION:
                performBinaryOperation("addition", (a, b) -> a + b);
                break;
            case SUBTRACTION:
                performBinaryOperation("subtraction", (a, b) -> a - b);
                break;
            case MULTIPLICATION:
                performBinaryOperation("multiplication", (a, b) -> a * b);
                break;
            case DIVISION:
                performDivision();
                break;
            case MODULUS:
                performBinaryOperation("modulus", (a, b) -> a % b);
                break;
            case DISPLAY_OPTIONS:
                displayOptions();
                break;
            case QUIT:
                System.out.println("Exiting the program. Goodbye!");
                break;
        }
    }

    private static void performBinaryOperation(String operationName, DoubleBinaryOperator operation) {
        double[] operands = getOperandsFromUser(operationName);
        System.out.println(operands[0] + " " + operationName + " " + operands[1] + " = " + operation.applyAsDouble(operands[0], operands[1]));
    }

    private static double[] getOperandsFromUser(String operationName) {
        System.out.println("You are performing " + operationName + " operation.");
        System.out.println("Enter the first number:");
        double a = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double b = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        return new double[]{a, b};
    }

    private static void performDivision() {
        double[] operands = getOperandsFromUser("division");
        if (operands[1] == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        System.out.println(operands[0] + " / " + operands[1] + " = " + (operands[0] / operands[1]));
    }

    private static void displayOptions() {
        System.out.println("You can perform various basic arithmetic operations. Press:");
        System.out.println("1 For addition.");
        System.out.println("2 For subtraction.");
        System.out.println("3 For multiplication.");
        System.out.println("4 For division.");
        System.out.println("5 To find remainder.");
        System.out.println("6 To display options.");
        System.out.println("7 To quit.");
    }
}
