package src.examsim.objectoriented;

public class Child extends Parent {
    @Override
    public Integer myMethod() {
        return 4;
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.myMethod());
    }
}
