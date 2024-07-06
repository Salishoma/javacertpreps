package examsim.objectoriented;

public class OuterClass {
    private String name;
    private static final int age = 10;

    public OuterClass(String name) {
        this.name = name;
    }

    class Innerclass {
        public Innerclass() {
            System.out.println("Name is: " + name + ", age is " + age);
        }
    }

    static class StaticInnerclass {
        public StaticInnerclass() {
            System.out.println("Name cannot be accessed by a static inner class because name is an instance field");
            System.out.println("Age is " + age);
        }

        public static void eat() {
            System.out.println("Eating test");
        }
    }

    void methodNestingLocalClass() {
        class LocalInner {
            void msg() {
                System.out.println("This is an inner class, field name with value " + name + " is accessible");
            }
        }
//        var var = 3;
        LocalInner localInner = new LocalInner();
        localInner.msg();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Oma");
        Innerclass innerclass = outerClass.new Innerclass();
        System.out.println(innerclass);

        StaticInnerclass staticInnerclass = new StaticInnerclass();
        System.out.println(staticInnerclass);
        StaticInnerclass.eat();

        outerClass.methodNestingLocalClass();
    }

    interface NestedInterface {
        class DeepNested {

        }
    }
}
