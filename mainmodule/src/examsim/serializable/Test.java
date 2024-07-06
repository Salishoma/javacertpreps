package src.examsim.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var stud = new Student("Lucy", 22);

        try( var objOutputStream = new ObjectOutputStream(
                new FileOutputStream("/Users/mac/Documents/dat/Student.txt")) ){
            objOutputStream.writeObject(stud);
        }

        try( var objInputStream = new ObjectInputStream(
                new FileInputStream("/Users/mac/Documents/dat/Student.txt")) ){
            stud = (Student)objInputStream.readObject();
            System.out.printf("%s : %d", stud.getName(), stud.getAge());
        }
    }
}

class Student implements Serializable {
    private transient String name;
    private int age;
 
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
}