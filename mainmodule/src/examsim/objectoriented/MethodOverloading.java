package src.examsim.objectoriented;

public class MethodOverloading {

    private static void m(int i) {
        System.out.print(1);
    }

    private static void m(int i1, int i2) {
        System.out.print(2);
    }

    private static void m(char... args) {
        System.out.print(3);
    }

    public static void main(String... args) {
        m('A');
        m('A', 'B');
        m('A', 'B', 'C');
        m('A', 'B', 'C', 'D');
    }
}
