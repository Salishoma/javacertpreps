package examsim.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
//    public static void main(String[] args) {
//        Locale.setDefault(new Locale("fr", "IT"));
//        var loc = new Locale("en", "US");
//        var rb =
//                ResourceBundle.getBundle("examsim.izo819.part1.resourcebundle.MyResourceBundle", loc);
//        System.out.println(rb.getObject("surprise"));
//    }

    private static void m(int i) {
        System.out.print(1);
    }

    private static void m(int i1, int i2) {
        System.out.print(2);
    }

    private static void m(char... args) {
        System.out.print(3);
    }

    public static void main(String... args) {
        m('A');
        m('A', 'B');
        m('A', 'B', 'C');
        m('A', 'B', 'C', 'D');
    }
}
