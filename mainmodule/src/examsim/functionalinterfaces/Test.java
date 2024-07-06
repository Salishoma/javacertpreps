package examsim.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Creator<T, R> {
    R create(T t);
}

class Log {

    Log() {
        System.out.println(1);
    }

    Log(String name) {
        System.out.println(2);
    }

}

public class Test {
    public static void main(String[] args) {
//        Creator<String, Log> obj = Log::new;
//        obj.create("Oma");

//        final String fName = "James";
//        String lName = "Gosling";
//        String name1 = fName + lName;
//        String name2 = fName + "Gosling";
//        String name3 = "James" + "Gosling";
//        System.out.println(name1 == name2);
//        System.out.println(name2 == name3);
//
//        List<String> list = new ArrayList<>(Arrays.asList("Z", "Y", "X"));
//        list.stream()
//                .sorted()
//                .findFirst()
//                .get();
//        System.out.println(list.get(2));

        List<String> alist = new ArrayList<>(4);
        alist.add(0, "MOVE");
        alist.add(2, "ON");

        System.out.println(alist);
    }
}