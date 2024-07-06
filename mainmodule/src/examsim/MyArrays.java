package examsim;

import java.util.Arrays;
import java.util.stream.Stream;

public class MyArrays {

    public static void main(String[] args) {
//        byte[] arr1 = { 5, 10, 15, 20 };
//        byte[] arr2 = { 5, 10, 15, 17 };
//        System.out.println(Arrays.compare(arr1, arr2));
//        System.out.println(Arrays.mismatch(arr1, arr2));

        for (int i = 0; i < 10; i++) {

            System.out.println(Stream.of(10, 0, -10).parallel()
                    .sorted()
                    .findAny()
                    .orElse(-1));
        }

    }
}
