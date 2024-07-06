package initialization;

/**
 * This is initialization.Animal class
 * @author Oma
 * @version 11
 */

public class Animal {

    static {
        System.out.println("Static initializer block");
    }

    public Animal() {
        System.out.println("In Animal Constructor");
    }

    {
        System.out.println("Default initializer block");
    }

    public static void main(String[] args) {

    }

    public double answer() {
        return 2;
    }

}
