package initialization;

import java.io.FileNotFoundException;

public class DummyCatch {

    public static void main(String[] args) throws FileNotFoundException {
        int testingFinally = testingFinally(3,12);
        System.out.println(testingFinally);
    }

    static int testingFinally(int a, int b) {
        try {
            return a;
        } finally {
            return a + b;
        }
    }
}
