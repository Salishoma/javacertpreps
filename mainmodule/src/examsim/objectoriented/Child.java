package src.examsim.objectoriented;

public class Child extends Parent {
    int i = 15;
//    @Override
    public Object myMethod() {
        return 6;
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.myMethod());
        Parent parent = new Child();
        System.out.println(parent.myMethod());
        System.out.println(parent.i);
    }
}
