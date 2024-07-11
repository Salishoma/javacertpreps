package src.records;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Oma", "My Address");
        Person person2 = new Person("Oma", "My Address");
        Person person3 = new Person("Temi");
        System.out.println(person == person2);
        System.out.println(person.equals(person2));
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person.name());

        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);
        person.walk();
        int age = Person.getAge();
        System.out.println(age);

        Person.Student student = new Person.Student(person.name(), person.address(), Person.getAge());
        System.out.println(student);

        School school = new School("School", "Location");
        System.out.println(school);
    }
}
