package src.com.oma;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome!!");
        arithmeticOperation();
//        new IllegalStateException("");
    }

    private static Scanner scanner = new Scanner(System.in);

    private static void arithmeticOperation() {
        display();
        int operation;
        boolean quit = false;
//        scanner.nextLine();
        while(true) {
            while (!(scanner.hasNextInt() && (operation = scanner.nextInt()) > 0 && operation < 8)) {
                System.out.println("You have entered an invalid value, valid value is from 1 to 7");
                display();
                scanner.nextLine();
            }
//            operation = scanner.nextInt();
            System.out.println("operation is: " + operation);
            switch(operation) {
                case 1:
                    add();
                    break;
                case 2:
                    subtract();
                    break;
                case 3:
                    multiply();
                    break;
                case 4:
                    divide();
                    break;
                case 5:
                    modulus();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    quit = confirmExit();
                    break;
            }
            if (quit) {
                break;
            }
            if (operation != 6) {
                System.out.println("Press 6 to display options...");
            }
            scanner.nextLine();
        }
    }

    private static void add() {
        double[] nums = extractNumbersFromScanner("addition");
        double a = nums[0];
        double b = nums[1];
        System.out.println(formatDouble(a) + " + " + formatDouble(b) + " = " + formatDouble(nums[0] + nums[1]));
    }

    private static void subtract() {
        double[] nums = extractNumbersFromScanner("subtraction");
        double a = nums[0];
        double b = nums[1];
        System.out.println(formatDouble(a) + " - " + formatDouble(b) + " = " + formatDouble(nums[0] - nums[1]));
    }

    private static void multiply() {
        double[] nums = extractNumbersFromScanner("multiplication");
        double a = nums[0];
        double b = nums[1];
        System.out.println(formatDouble(a) + " x " + formatDouble(b) + " = " + formatDouble(nums[0] * nums[1]));
    }

    private static void divide() {
        double[] nums = extractNumbersFromScanner("division");
        double a = nums[0];
        double b = nums[1];
        if (b == 0) {
            throw new IllegalStateException("Denominator cannot be zero");
        }
        System.out.println(formatDouble(a) + " / " + formatDouble(b) + " = " + formatDouble(nums[0] / nums[1]));
    }

    private static void modulus() {
        double[] nums = extractNumbersFromScanner("modulus");
        double a = nums[0];
        double b = nums[1];
        if (b == 0) {
            throw new IllegalStateException("Denominator cannot be zero");
        }
        System.out.println(formatDouble(a) + " mod " + formatDouble(b) + " = " + formatDouble(nums[0] % nums[1]));
    }

    private static double[] extractNumbersFromScanner(String operation) {
        System.out.println("You are performing " + operation + " operation");
        System.out.println("Enter first number");
        analyzeInput();
        double a = scanner.nextDouble();
        System.out.println("Enter second number");
        analyzeInput();
        double b = scanner.nextDouble();
        return new double[]{a, b};
    }

    private static void analyzeInput() {
        while (!scanner.hasNextDouble()) {
            String nextLine = scanner.nextLine();
            if (!nextLine.isEmpty()) {
                System.out.println("Please enter a number");
            }
        }
    }

    private static boolean confirmExit() {
        System.out.println("Are you sure you want to exit? Type y for yes or any letter to continue and then press enter to confirm");
        String quit = scanner.nextLine();
        return quit.equalsIgnoreCase("y");
    }

    private static void display() {
        System.out.println("You can perform various basic arithmetic operations, press:\n" +
                "1 For addition.\n2 For subtraction.\n3 For multiplication.\n4 For division.\n" +
                "5 To find remainder.\n6 to display options.\n7 to quit."
        );
    }

    private static String formatDouble(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        return decimalFormat.format(number);
    }


}
