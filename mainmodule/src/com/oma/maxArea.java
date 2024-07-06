package src.com.oma;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

public class maxArea {

    public static int getMaxTotalArea(List<Integer> sideLengths) {
        sideLengths.sort(Comparator.reverseOrder());
        List<Integer> arrayList = new ArrayList<>();
        Timestamp timestamp = Timestamp.from(Instant.now());
        int res = 0;

        for (int i = 0; i < sideLengths.size(); i += 2) {
            if (Objects.equals(sideLengths.get(i), sideLengths.get(i + 1))) {
                arrayList.add(sideLengths.get(i));
            } else if (Objects.equals(sideLengths.get(i) - 1, sideLengths.get(i + 1))) {
                arrayList.add(sideLengths.get(i) - 1);
            }
            if (arrayList.size() == 2) {
                res += (arrayList.get(0) * arrayList.get(1));
                arrayList.clear();
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(2, 6, 6, 2, 3, 5)));
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2)));
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4)));
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(10, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 8)));
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(1, 1, 2, 2)));
//        System.out.println("Result: " + getMaxTotalArea(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        List<String> list = new ArrayList<>(4);
        list.add(0, "MOVE");
        list.add(2, "ON");
        System.out.println(list);

        String text = "I am going to pass OCP exam in first attempt";
        Stream<String> stream = Arrays.stream(text.split(" "));
//        IntStream.of(1,2,3).summaryStatistics();
        IntSummaryStatistics stat = stream.mapToInt(s -> s.length())
                .summaryStatistics();
        System.out.println(stat.getMax());
    }
}
