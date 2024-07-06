package examsim.resourcebundle;

import java.util.ListResourceBundle;

public class MyResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", "English with no specified country"}};
        return arr;
    }
}
