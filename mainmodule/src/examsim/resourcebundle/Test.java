package src.examsim.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("fr", "IT"));
        var loc = new Locale("en", "US");
        var rb =
                ResourceBundle.getBundle("examsim.izo819.part1.resourcebundle.MyResourceBundle", loc);
        System.out.println(rb.getObject("surprise"));
    }
}
