package src.examsim.resourcebundle;

import java.util.ListResourceBundle;

public class MyResourceBundle_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", "This is US"}};
        return arr;
    }
}
