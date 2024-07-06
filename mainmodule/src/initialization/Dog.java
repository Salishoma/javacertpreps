package initialization;

public class Dog {
    public Dog() {
        System.out.println("In Dog Constructor");
    }
    private Animal animal = new Animal();

    {
        System.out.println("Default initializer block of Child");
    }

    static {
        System.out.println("Static initializer block of Child");
    }

    public static void main(String[] args) {
        var dog = new Dog();
    }

}
