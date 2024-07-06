package src.examsim.functionalinterfaces;

@FunctionalInterface
public interface MyFunctionalInterface {
    void eat();

    static void walk() {
        System.out.println("He is working");
    }

    default void talk() {
        System.out.println("He is talking");
    }
}
