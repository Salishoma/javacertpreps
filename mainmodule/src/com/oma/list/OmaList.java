package src.com.oma.list;

import java.util.ArrayList;

public class OmaList<T> extends ArrayList<T> {


    {
        Integer displayInputArrayOfDouble = -12335;
        String aString
                = displayInputArrayOfDouble.toString();
        char[] chrArray
                = aString.toCharArray();

        if (!Character.isDigit(chrArray[0])) {
            System.out.println("Please enter Digit");
        }
    }
}
