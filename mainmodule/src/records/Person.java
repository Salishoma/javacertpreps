package src.records;

public record Person(String name, String address) {

    private static int age = 3;

    static {
        System.out.println("Before constructor");
    }

    public Person (String name) {
        this(name, "New Address");
    }

    record Student(String name, String address, int age){}

    public Person {
        System.out.println("Person constructor");
    }

    public static int getAge() {
        return age;
    }

    public void walk() {
        System.out.println(name + " can walk");
    }
}

record School(String name, String location){}
