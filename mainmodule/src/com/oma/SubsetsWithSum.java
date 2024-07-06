package com.oma;

import com.oma.functionalinterfaces.TriFunction;
import com.oma.stream.OmaStream;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class SubsetsWithSum {
    public static final double min = 5;

    // Function to generate all subsets and store their sums in an array
    public static int[] generateSubsetsAndSum(int[] set) {
        int n = set.length;
        int[] subsetSums = new int[1 << n];  // Array to hold the sums of all subsets

        // Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            int subsetSum = 0;

            // Check each bit to determine which elements are in the subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetSum += set[j];
                }
            }

            // Store the sum of the current subset in the array
            subsetSums[i] = subsetSum;
        }

        return subsetSums;
    }

    // Main function to test the generateSubsetsAndSum function
    public static void main(String[] args) {
//        int[] reliability = {1, 2, 4};
//        int[] reliability = {1, 2, 4};
//        List<Integer> reliability = Arrays.asList(1000000);
//        List<Integer>  availability = Arrays.asList(1000000);
//        int[] subsetSums = generateSubsetsAndSum(set);
//        int res = generateSubsets(reliability, availability);
//        int res = generateSubsetList(reliability, availability);

        // Print the array of subset sums
//        System.out.print("Subset sums: " + Arrays.toString(subsetSums));
//        System.out.print("res: " + res);

//        for (int sum : subsetSums) {
//            System.out.print(sum + " ");
//        }
//        testRestParams("Testing", 2, 4, 3);

        OmaStream<ArrayList<Integer>> omaStream = new OmaStream<>(new ArrayList<>(Arrays.asList(1, 2)));
//        omaStream.map(x -> x * 2).forEach(System.out::println);
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        Comparator<String> stringComparator = String::compareTo;
        BinaryOperator<String> concat = String::concat;
        BiPredicate<String, String> equalsIgnoreCase = String::equalsIgnoreCase;
        boolean test = equalsIgnoreCase.test("A", "a");
        Function<String, char[]> toCharArray = String::toCharArray;
        Predicate<String> isEmpty = String::isEmpty;
        Function<String, Integer> stringIntegerFunction = String::length;
        BiFunction<String, Integer, String> stringIntegerStringBiFunction = String::substring;
        TriFunction<String, Integer, Integer, String> stringTriFunction = String::substring;
        String abcde = stringTriFunction.apply("abcde", 1, 3);
//        "".;
        System.out.println(test);
        System.out.println("abcde: " + abcde);
    }

    public static int generateSubsets(int[] reliability, int[] availability) {
        int n = availability.length;
        int[] subsetSums = new int[1 << n];  // Array to hold the sums of all subsets
        int result = 1;

        // Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            int subsetSum = 0;
            int min = Integer.MAX_VALUE;
            // Check each bit to determine which elements are in the subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetSum += reliability[j];
                    min = Math.min(min, availability[j]);
                }
            }
            result = Math.max((min * subsetSum) % 100000007, result);

            // Store the sum of the current subset in the array
//            subsetSums[i] = subsetSum;
        }

        return result;
    }

    public static int generateSubsetList(List<Integer> reliability, List<Integer> availability) {
        int n = availability.size();
        int[] subsetSums = new int[1 << n];  // Array to hold the sums of all subsets
        int result = 1;

        // Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            int subsetSum = 0;
            int min = Integer.MAX_VALUE;
            // Check each bit to determine which elements are in the subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetSum += reliability.get(j);
                    min = Math.min(min, availability.get(j));
                }
            }
            result = Math.max((min * subsetSum), result);

            // Store the sum of the current subset in the array
//            subsetSums[i] = subsetSum;
        }

        return result;
    }

    private static void testRestParams(String a, int b, int ...c) {
        int sum = Arrays.stream(c).sum();
        int result = b * sum;
//        Consumer
        System.out.println("a: " + a + ", result: " + result);

    }
}
