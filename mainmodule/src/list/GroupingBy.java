package src.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {


}

class Student {
    public static enum Grade {A, B, C, D, F}
    private String name;
    private Grade grade;

    public Student(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return  name + ":"+ grade;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("S1", Grade.A), new Student("S2", Grade.A),
                new Student("S3", Grade.C));

        Map<Grade, List<String>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("collect: " + collect);
    }
}
