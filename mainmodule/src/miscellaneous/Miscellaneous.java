package src.miscellaneous;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Miscellaneous {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,2,4,6,8);
        String firstName = "Oma";
        final String lastName = "Shadu";
        String name = firstName + lastName;
        String Shadu = firstName + "Shadu";
        String oma = "Oma" + "Shadu";
        String oma1 = "Oma" + lastName;
        System.out.println(name == Shadu);
        System.out.println(oma == name);
        System.out.println(name == oma1);
        System.out.println(Shadu == oma1);
        System.out.println(Shadu == oma);
        System.out.println(oma == oma1);

        Paths.get("a");
        list.replaceAll(i -> i + 1);
        System.out.println(list);
        Boolean [] arr = new Boolean[2];
        boolean[] arr1 = new boolean[2];
        System.out.println(arr[0] + ":" + arr[1]);
        System.out.println(arr1[0] + ":" + arr1[1]);

        short x = 2;
        byte y = 127;
        long lo = (int) 3.24f;
        int l1 = 'a';
        char c = (short)'d';
        System.out.println("Start of program");
        long l = 'b';
        long in = 2l;
        boolean b = true;
        System.out.println("l: " + l);
        long lon = (byte) 3.8;
        float fl = (int) 4.2;
        double db = (short) 4.2;
        double dd = c;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println("Argument " + (i + 1) + " is " + arg);
        }
        System.out.println("End of program");
        System.out.println("12345".charAt(6));
        long ac = 'a';
    }
}
