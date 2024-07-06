package src.examsim.resourcebundle;

import java.util.ListResourceBundle;

public class MyResourceBundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"surprise", "SURPRISE!"}};
    }
}
