package src.consume;

import java.util.List;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        var list1 = List.of("BC"); //Line n1
        var list2 = List.of("A"); //Line n2
        var list3 = List.of(1,2,3);
        Integer reduce = list3.stream().reduce(0, Integer::sum);
        System.out.println("Reduced value: " + reduce);
        list1 = list2; //Line n3
//        System.out.println(list1.size()); //Line n4

        long seed = 10;

        var stream = Stream.iterate(seed, i -> i <= 12, i -> i + 2);
//        stream.forEach(System.out::println);

        LongFunction<LongUnaryOperator> func = m -> n -> n / m; //Line n2
        stream.mapToLong(i -> i).map(func.apply(2)).forEach(System.out::println); //Line n3

//        var list = List.of("S", "P", "I", "R", "I", "T");
//
//        list.parallelStream().forEachOrdered(System.out::println);
//
//        var date = new Date();
//        var format = new SimpleDateFormat("'Time is:' hh:mm:ss a");
//        System.out.println(format.format(date));
//        MyUtil.print();
//        ServiceLoader<AvailableService> serviceLoader = ServiceLoader.load(AvailableService.class);
//        serviceLoader.stream()
//                .forEach(provider -> provider.get().available());
    }
}
