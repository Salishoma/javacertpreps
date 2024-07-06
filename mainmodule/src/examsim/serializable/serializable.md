### Serialization of Static and Transient Fields
When serializing an object, state of transient and static fields are not persisted.

While de-serializing, transient fields are initialized to default values (null for reference type and respective Zeros for primitive types) and static fields refer to current value.

```java
package com.udayankhattry.ocp;
 
import java.io.*;
 
class Person {
    private String name;
    private int age;
 
    public Person(){}
 
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
}
 
class Student extends Person implements Serializable {
    private String course;
 
    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }
 
    public String getCourse() {
        return course;
    }
}
 
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var stud = new Student("Aafia", 24, "Chemistry");
        try (var oos = new ObjectOutputStream(new FileOutputStream(("F:\\stud.ser")));
             var ois = new ObjectInputStream(new FileInputStream("F:\\stud.ser")))
        {
            oos.writeObject(stud);
 
            var s = (Student) ois.readObject();
            System.out.printf("%s, %d, %s", s.getName(), s.getAge(), s.getCourse());
        }
    }
}
```

Variable 'stud' infers to Student type, variable 'oos' infers to ObjectOutputStream, variable 'ois' infers to ObjectInputStream and variable 's' infers to Student type.



Class Student implements Serializable but it's super class Person is not Serializable.



While de-serializing of Serializable class, constructor of that class is not invoked. But as Parent class is not Serializable, hence to construct the Parent class object, a no-argument constructor in Parent class is needed. This no-argument constructor initializes the properties to their default values.



Person class has no-argument constructor. So while de-serialization, name and age are initialized to their default values: null and 0 respectively. course refers to "Chemistry" as it belongs to Serializable class, Student.



In the output, you get 'null, 0, Chemistry'.