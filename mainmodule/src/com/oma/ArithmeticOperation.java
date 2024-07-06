package com.oma;

import java.util.function.BinaryOperator;

public class ArithmeticOperation {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        BinaryOperator<Integer> addOperator = ArithmeticOperation::add;
        BinaryOperator<Integer> subtractOperator = ArithmeticOperation::subtract;
        Integer add = addOperator.apply(2, 5);
        Integer subtract = subtractOperator.apply(12, 3);

        System.out.println("Add: " + add);
        System.out.println("subtract: " + subtract);
    }
}