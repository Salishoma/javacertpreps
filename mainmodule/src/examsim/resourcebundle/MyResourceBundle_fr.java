package examsim.resourcebundle;

import java.util.ListResourceBundle;

public class MyResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", 1001}};
        return arr;
    }
}