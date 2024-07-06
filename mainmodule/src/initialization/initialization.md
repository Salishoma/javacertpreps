We want to check on different ways in which classes(objects) are called with and without inheritance when they have static blocks and variables, default blocks, and constructors. Let's make the dog class inherit the animal class.

Animal class
```java
public class Animal {
    private String name;

    static {
        System.out.println("Static initializer block");
    }

    public Animal() {
        System.out.println("In Animal Constructor");
    }

    {
        System.out.println("Default initializer block");
    }
}
```
###Inheritance
Dog class inherits from Animal class.\
We start with the case where the animal field is static
```java
public class Dog extends Animal {
    private static Animal animal = new Animal();
    public Dog() {
        System.out.println("In Dog Constructor");
    }

    {
        System.out.println("Default initializer block of Child");
    }
    
    static {
        System.out.println("Static initializer block of Child");
    }

    public static void main(String[] args) {
        var dog = new Dog();
    }

}
```
```
The result gotten in that order is:
Static initializer block
Default initializer block
In Animal Constructor
Static initializer block of Child
Default initializer block
In Animal Constructor
Default initializer block of Child
In Dog Constructor
```
If we remove the static from the animal field i.e.
```java
public class Dog extends Animal {
    private Animal animal = new Animal();
    public Dog() {
        System.out.println("In Dog Constructor");
    }

    {
        System.out.println("Default initializer block of Child");
    }
    
    static {
        System.out.println("Static initializer block of Child");
    }

    public static void main(String[] args) {
        var dog = new Dog();
    }

}
```
Result will be
```
Static initializer block
Static initializer block of Child
Default initializer block
In Animal Constructor
Default initializer block
In Animal Constructor
Default initializer block of Child
In Dog Constructor
```
###Without Inheritance
If we remove the extends keyword from the dog class i.e.
```java
public class Dog {
    private Animal animal = new Animal();
    public Dog() {
        System.out.println("In Dog Constructor");
    }

    {
        System.out.println("Default initializer block of Child");
    }
    
    static {
        System.out.println("Static initializer block of Child");
    }

    public static void main(String[] args) {
        var dog = new Dog();
    }

}
```
Result will be
```
Static initializer block of Child
Static initializer block
Default initializer block
In Animal Constructor
Default initializer block of Child
In Dog Constructor
```
If we move the animal field to below Dog constructor i.e
```java
public class Dog {
    public Dog() {
        System.out.println("In Dog Constructor");
    }
    private Animal animal = new Animal();

    {
        System.out.println("Default initializer block of Child");
    }
    
    static {
        System.out.println("Static initializer block of Child");
    }

    public static void main(String[] args) {
        var dog = new Dog();
    }

}
```
Result will be
```
Static initializer block of Child
Static initializer block
Default initializer block
In Animal Constructor
Default initializer block of Child
In Dog Constructor
```
We can see that in all these cases, static blocks, fields etc takes preference, then followed by default, and then constructor. Also, we observed that
when there is inheritance, the behavior is slightly different(static blocks of parents are treated first), but still follows similar pattern.

