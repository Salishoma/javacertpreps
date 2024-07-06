#Java Certification Preparation

## Encapsulation

Java has six encapsulation types, they are local, private, default(package-private), protected, public, exports(package).

Reference - Variable that points to object  
``` 
initialization.Animal(class name) dog(object reference) = new initialization.Animal()(object);  
```

Combination of method name and parameter is signature

### Generate Java Doc
Javadoc is generated using the symbol  
/**  
  *@param parameter of a function  
  *@return the return type of the function  
  *@Author Abubakar Salifu  
  *@since 11  
*/.
To generate Javadoc, type javadoc nameOfFile.java, it will generate some files, click on the index.html it generated to see the docs

###Compiling a File
To compile a file classA, run the command in the terminal:  
`javac classA.java`, the file will be compiled in a target folder located in the root directory of the project. To compile it in another folder, run
`javac -d nameoffolder classA.java`. To execute the compiled class, run `java -cp nameoffolder classA`
#####N:B.: You can use -classpath or --classpath in place of -cp


### Create Jar File
To create a jar file, use `jar -cvf nameOfFile.jar`.
This will create a jar file in the current directory. the cvf means create verbose file.

### Run a Jar File
To run a jar file, type `java -cp ".;c:\temp\myJar.jar" initialization.Animal`. 
cp means classpath, . means current directory. If you don't know the name of your jar file, you can use * in place of the jar name.

### Casting
You can cast primitives(excluding boolean) with byte, short, and int into another primitive. e.g., long lo = (byte) 3.8;

### String and StringBuilder
String and StringBuilder implements CharSequence interface.
Strings are immutable while StringBuilder are mutable.

Strip and trim does the same thing, however, strip supports unicode but trim does not support unicode

Strings computed by concatenation at compile time, will be referred by String Pool during execution. Compile time String concatenation happens when both of the operands are compile time constants, such as literal, final variable etc.

Whereas, Strings computed by concatenation at run time (if the resultant expression is not constant expression) are newly created and therefore distinct.

toString() method defined in StringBuilder class doesn't use String literal, rather it uses the constructor of String class to create the instance of String class.

repeat() method in String class was added in Java 11

StringBuilder does not have the trim() method, though it has trimToSize().
```
public String repeat(int count) {}
```

Returns the new String object whose value is the concatenation of this String repeated 'count' times.
String, StringBuilder and StringBuffer are final classes

### Streams
Streams was introduced in Java 8.
Stream does not have summary statistics, IntStream, LongStream and DoubleStream does. 

To convert stream to intStream, use stream.mapToInt.

All streams in Java implements BaseStream interface and this interface has parallel() and sequential() methods. Hence all streams can either be parallel or sequential.

findAny() may return any element from the stream and if a stream is not parallel, it will most likely return first element from the sorted stream, but this is not the guaranteed result. findFirst() will always give first element(parallel or not)


### Modules
Modules was introduced in Java 9.

If module-info.java file is missing or is placed at wrong position, then given javac command would cause "error: module office not found in module source path"

To compile a module, use javac --module-source-path javacertprep -d out $(find javacertprep -name "*.java").
to run the module, use java --module-path out -m mainmodule/consume.Main, where javacertprep is the directory containing the modules,
out is the output directory, main module is the name of the module where the Main-Class is in, consume.Main is the Main-Class to be executed.

If 'out' directory doesn't contain jar file, it means exploded module is available under 'out'. Hence, all the class files must be available under subdirectories of out directory

Error occurred during initialization of boot layer
java.lang.LayerInstantiationException: Package module.service in both com.lib.module premium and com.lib.module community

This error occurs when the same package is present in modules that are been implemented by another com.lib.module. To resolve this issue, you need to ensure that each package is uniquely contained within a single com.lib.module. Here are steps to help you fix this problem

- **com.lib.module-path** – We use the –com.lib.module-path option to specify the com.lib.module path. This is a list of one or more directories that contain your modules.
- **add-reads** – Instead of relying on the com.lib.module declaration file, we can use the command line equivalent of the requires directive; –add-reads.
- **add-exports** – Command line replacement for the exports directive.
- __add-opens__ – Replace the open clause in the com.lib.module declaration file.
- **add-modules** – Adds the list of modules into the default set of modules
- **list-modules** – Prints a list of all modules and their version strings
- **patch-com.lib.module** – Add or override classes in a modules
- **illegal-access=permit|warn|deny** – Either relax strong encapsulation by showing a single global warning, shows every warning, or fails with errors. The default is permit.

### Java I/O
Files.move(Path source, Path target, CopyOption... options) method throws following exceptions-

[Copied from the Javadoc]

1. UnsupportedOperationException - if the array contains a copy option that is not supported

2. FileAlreadyExistsException - if the target file exists but cannot be replaced because the REPLACE_EXISTING option is not specified (optional specific exception)

3. DirectoryNotEmptyException - the REPLACE_EXISTING option is specified but the file cannot be replaced because it is a non-empty directory (optional specific exception)

4. AtomicMoveNotSupportedException - if the options array contains the ATOMIC_MOVE option but the file cannot be moved as an atomic file system operation.

5. IOException - if an I/O error occurs

6. SecurityException - In the case of the default provider, and a security manager is installed, the checkWrite method is invoked to check write access to both the source and target file.



As target directory is not empty and StandardCopyOption.REPLACE_EXISTING is used hence DirectoryNotEmptyException is thrown at runtime.

### Inner Classes
There are basically four types of inner classes in java.

* Nested Inner Class: A class declared inside a top-level class or interface. 
* Method Local Inner Classes: A class declared inside a method
* Static Nested Classes: A class defined inside another class having keyword static
* Anonymous Inner Classes: Classes declared in another class that have no name, they are from abstract classes or interfaces. Their names are decided by compiler.

Method-local inner class can be defined inside methods(static and non-static) and initializer blocks(static and non-static).
Before Java 16,  regular inner class and method-local inner class cannot define anything static, except static final variables, but since Java 16, they are allowed to have static fields that
are compiled time constants as members(They can't have static methods though).

### Nested Interfaces
An interface that is declared within another interface or class, is known as a nested interface.
* The nested interface must be public if it is declared inside the interface, but it can have any access modifier if declared within the class.
* Nested interfaces are declared static

If we define a class inside the interface, the Java compiler creates a static nested class.
You cannot explicitly specify protected and private for nested classes and nested interfaces inside an interface.

### Static
Static fields, methods, and classes belong to the class and are created once when the class is loaded into memory

Static methods and classes do not have direct access to instance fields.

### Polymorphism
The static method of subclass cannot hide the instance method of superclass

When overriding a method in a parent class, the access modifier of the child class should have equal(or higher) accessibility than that of the parent class


### List
Arrays.asList(...) method returns a fixed-size list backed by the specified array and as list is backed by the specified array therefore, you cannot add or remove elements from this list. Using add/remove methods cause an exception at runtime. But you can invoke the set(int index, E element) method on the returned list.

This behavior is bit different from the List.of(...) method, which returns unmodifiable list, hence calling add/remove/set methods on the unmodifiable list throws an exception at runtime.

Static overloaded methods of(...) were added to List interface in Java 9 and can only be invoked by using List.of(...)

### var
The Reserved type name var was added in Java 10 to infer the type of object created.

The identifier 'var' is not a keyword, hence 'var' can still be used as variable name, method name or package name but it cannot be used as a class or interface name.

###Map
TreeMap is the sorted map on the basis on natural ordering of keys (if comparator is not provided).



The natural order for enum elements is the sequence in which they are defined

###JDBC
executeQuery method closes previously opened ResultSet object on the same Statement object.
```java
public class Test {
    public static void main(String[] args) throws SQLException {
        var url = "jdbc:mysql://localhost:3306/ocp";
        var user = "root";
        var password = "password";
        try (var con = DriverManager.getConnection(url, user, password);
             var stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            var res1 = stmt.executeQuery("SELECT * FROM EMPLOYEE ORDER BY ID");
            var res2 = stmt.executeQuery("SELECT * FROM EMPLOYEE ORDER BY ID DESC");
            res1.next();
            System.out.println(res1.getInt(1));
            res2.next();
            System.out.println(res2.getInt(1));
        }
    }
}
```
From the above code snippet, variables 'url', 'user', 'password' and 'query' infer to String type. Variable 'con' infers to Connection type and variable 'stmt' infers to Statement type. Variables 'res1' and 'res2' infer to ResultSet type.



executeQuery method closes the previously opened ResultSet object on the same Statement object.



ResultSet object referred by 'res1' gets closed when 2nd executeQuery method is executed. So `res1.next();` throws SQLException at runtime.

### Character
A character is a Java whitespace character if and only if it satisfies one of the following criteria:

It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, or PARAGRAPH_SEPARATOR) but is not also a non-breaking space ('\u00A0', '\u2007', '\u202F').

It is '\t', U+0009 HORIZONTAL TABULATION.

It is '\n', U+000A LINE FEED.

It is '\u000B', U+000B VERTICAL TABULATION.

It is '\f', U+000C FORM FEED.

It is '\r', U+000D CARRIAGE RETURN.

It is '\u001C', U+001C FILE SEPARATOR.

It is '\u001D', U+001D GROUP SEPARATOR.

It is '\u001E', U+001E RECORD SEPARATOR.

It is '\u001F', U+001F UNIT SEPARATOR.

###Arrays
Arrays.compare returns the first non-zero difference between two arrays
eg
```
        byte[] arr1 = { 5, 10, 15, 20 };
        byte[] arr2 = { 5, 10, 15, 17 };
        System.out.println(Arrays.compare(arr1, arr2));
```
This will return 3 since the first non-zero difference(20 and 17) is 3.

Arrays.mismatch returns the index of the first non-zero difference between two arrays
eg
```
        byte[] arr1 = { 5, 10, 15, 20 };
        byte[] arr2 = { 5, 10, 15, 17 };
        System.out.println(Arrays.mismatch(arr1, arr2));
```
This will return 3 since the index of the first non-zero difference between the two arrays is 3.
N.B.: The compare and mismatch compares two primitive arrays.

### SuppressWarnings
The annotation '@SuppressWarnings' is used to suppress compiler warning on a class or method. You can pass any value in the SuppressWarnings annotation(unrecognized values are ignored), 
the Java specification mandates only three values - unchecked, deprecation, and removal. Different compilers and IDEs may support other values in addition to these three.

###LocalDate
LocalDate is immutable.

###Interfaces
From Java 8, Interface can have static methods, as well as 
default methods, Java 9 allows interface to have private methods. Interface cannot have protected methods. It cannot have non-public fields and instance fields.
Fields of an interface are always public, static, and final. Interface cannot have final methods.

Interface allows multiple implementation inheritance through default methods. Multiple inheritance of implementation is the ability to inherit method definitions from multiple classes
Prior to Java 8, interfaces were not allowed to contain any method implementation but with Java 8, interfaces can have method implementations in the form of "default" methods. 
This effectively allows a class inherit implementations from multiple sources. In other words, default methods introduce one form of multiple inheritance of implementation.  
However, you still cannot have a class that implements two unrelated interfaces where both the interfaces contain a default method with the same signature unless the class provides an 
implementation for that method itself. For example, in the following code, class C will not compile:
```java
interface I1{ 
    default void m1(){ 
        System.out.println("in I1.m1"); 
    } 
} 

interface I2{ 
    default void m1(){ 
        System.out.println("in I2.m1"); 
    } 
}  

class CI implements I1, I2{} //This class will not compile. 

//This class will compile because it provides its own implementation of m1. 
class C2 implements I1, I2{
    public void m1(){ 
        System.out.println("in C2.m1");
    } 
}
```
You can have a class inherit a method with the same signature from an interface and a superclass though. This is allowed because the superclass's version always 
overrides the interface's version. The class doesn't get two implementations. It gets only the version from super class.

###Anonymous class
Anonymous class can never be static even if created in a static method.

###PreparedStatement
PreparedStatement remembers the value you set for every parameter until you close that preparedStatement object(by calling close on it). So if you
execute the same query multiple times with same values for some columns, you don't need to set the values for those columns again and again, setting them once is fine.
You need to set values for only those columns that requires a change.

### java.time package
The java.time package contains main api for dates, times, instants, and durations. The classes defined in this package
represents the principle date-time concepts, including instants, durations, dates, times, time-zones and periods.
All the classes in this package are immutable and thread-safe.

###final class
All methods in a final class are implicitly final.