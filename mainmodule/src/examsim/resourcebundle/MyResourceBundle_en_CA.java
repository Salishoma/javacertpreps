package examsim.resourcebundle;

import java.util.ListResourceBundle;

public class MyResourceBundle_en_CA extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", 12.64}};
        return arr;
    }
}
