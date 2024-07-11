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

If a request is made from an automatic module to load a type whose package is not defined in any known module then the module system will attempt to load it from the classpath.

Unnamed module reads every other module. In other words, a class in an unnamed module can access all exported types of all modules.

A named module cannot access any random class from the classpath. If your named module requires access to a non-modular class, you must put the non-modular class/jar on module-path and load it as an automatic module.
Further, you must also put an appropriate "requires" clause in your module-info.

Bottom Up Approach for modularizing an application  While modularizing an app using the bottom-up approach, you need to convert lower level libraries i.e. dependencies into modular jars before you can convert the higher level libraries. 
For example, if a class in A.jar directly uses a class from B.jar, and a class in B.jar directly uses a class from C.jar, you need to first modularize C.jar and then B.jar before you can modularize A.jar.  
Thus, bottom up approach is possible only when the dependencies are modularized already. Effectively, when bottom-up migration is complete, every class/package of an application is put on the module-path. Nothing is left on the classpath.  
Top Down Approach for modularising an application  While modularizing an app in a top-down approach, you need to remember the following points -  
1. Any jar file can be converted into an automatic module by simply putting that jar on the module-path instead of the classpath. Java automatically derives the name of this module from the name of the jar file. An automatic module implicitly exports all of its packages.  
2. Any jar that is put on classpath (instead of module-path) is loaded as a part of the unnamed module. The unnamed module implicitly exports all of its packages.  
3. An explicitly named module (which means, a module that has an explicitly defined name in its module-info.java file) can specify dependency on an automatic module just like it does for any other module 
i.e. by adding a requires <module-name>; clause in its module info but it cannot do so for the unnamed module because there is no way to write a requires clause without a name. In other words, an explicitly named module can "read" classes present in an automatic module 
using an appropriate requires clause but cannot read classes in the unnamed module by any means.  
4. An automatic module exports all of its packages and is allowed to read all packages exported by other modules. Thus, a class in an automatic module can access: all packages of other automatic modules + all packages exported by explicitly named modules + all packages of the unnamed module.  
5. The unnamed module exports all of its packages and is allowed to read all packages exported by other modules. 
Thus, a class in the unnamed module can access: all packages of the unnamed module + all packages of automatic modules + all packages exported by explicitly named modules.   Thus, if your application jar A directly uses a class from another jar B, then you would have to convert B into a module (either named or automatic). 
If B uses another jar C, then you can leave C on the class path if B hasn't yet been migrated into a named module. Otherwise, you would have to convert C into an automatic module as well.  Note: There are two possible ways for an automatic module to get its name: 
1. When an Automatic-Module-Name entry is available in the manifest, its value is the name of the automatic module.
2. Otherwise, a name is derived from the JAR filename (see the ModuleFinder JavaDoc for the derivation algorithm) - Basically, hyphens are converted into dots and the version number part is ignored. So, for example, if you put mysql-connector-java-8.0.11.jar on module path, its module name would be mysql.connector.java


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
All primitive wrappers are final classes, though java.lang.Number is not final, Integer, Long, Double etc. extends Number.\
java.lang.System is final as well

###Indent
JDK 12 introduced indent() method in Java.lang.String class. This method is useful to add or remove white spaces from the beginning of 
the line to adjust indentation for each string line.

When a string is provided to indent() method,

1. It calls lines() function
2. Then, for each line, does indentation based on integer value provided as per user cases discussed below:
   1. If n>0 (Positive)
      1. Then n white spaces are added at the starting of each line and each line is suffixed with “\n”.
   2. If n==0 
      1. Then the indentation remains as it is, only line is suffixed with “\n”.
   3. If n<0 (Negative), then 
      1. If (+n) > leading white spaces available\
               Then all leading white spaces are removed for each line and each line is suffixed with “\n”
      2. If (+n) < leading white spaces available\
               Then (+n) leading white spaces are removed for each line and each line is suffixed with “\n”
3. Then, suffix each line with “\n”.
4. Then, concatenates resulting string lines and returns

###StripIndent
Introduced in Java 12 as a part of JEP 355.

- Useful for adjusting the indentation of multi-line strings.

- It strips leading and trailing white spaces and adjusts indentation.

- This method is particularly beneficial when working with text blocks, which were also introduced in Java 12.

### Function
java.util.function package contains int, double, and long (but no float) versions of all the functional interfaces. For example, 
there is an IntFunction, a DoubleFunction, and a LongFunction, which are int, double, and long, versions of Function.

These functions are used along with primitive specialized versions of streams such as IntStream, DoubleStream, and LongStream.

###Sealed classes
The release of Java SE 17 introduced sealed classes (JEP 409). This feature enables more fine-grained inheritance control in Java.
N.B.: Sealed classes were introduced as a preview in Java 15
```java 
public abstract sealed class DocType { }
```
Ideally, a sealed class must have a 'permits' clause but there is an exception to this rule. If you define a subclass of a sealed class in the same source file, the 'permits' clause is not needed. 
For example, if the Java source file containing the above definition also contains the following definition, the above definition would be valid: final class Pdf extends DocType{ }
A sealed class can never be final.

###Records
Record wa introduced in Java 14, important points on Java records.\
A record declaration specifies a new record class, a restricted kind of class that defines a simple aggregate of values. A record declaration implicitly creates instance fields, which are private and final. It also implicitly creates public accessor methods for these fields. Together, the fields and the corresponding methods are called record "components". An accessor method is a method with the same name as the record field and an empty formal parameter list. Such methods act as the getter methods for those fields. For example:
```java
public record Student(
int id, //record component
String name //record component
) //record header
{ } //record body
```
This is roughly equivalent to the following class:
```java
public final class Student extends Record
{
private final int id; //component field
private final String name; //component field
public Student(int id, String name){  //canonical constructor
this.id = id;
this.name = name;
}

public int id(){ return id; } //accessor
public String name(){ return name; } //accessor

//hashCode, equals, and toString methods are also provided by the compiler.
}
```
Observe that the accessor methods do not follow the JavaBeans convention (where a getter method is prefixed with get). Further, observe that instance fields are final and the class does not have any setters.  
**<center>Basic Rules</center>**
1. You can define a top level record i.e. directly under a package, a nested member record class i.e. within a class/interface, or a local record i.e. within a method. 
2. A nested record class is implicitly static. That is, every member record class and local record class is static. It is permitted for the declaration of a member record class to redundantly specify the static modifier, but it is not permitted for the declaration of a local record class. 
3. A record class is implicitly final. It is permitted for the declaration of a record class to redundantly specify the final modifier. 
4. Records cannot be marked abstract, sealed, or non-sealed. 
5. The direct superclass type of record class is Record. Thus, a record cannot have an extends clause and so it cannot extend any other class.
6. The serialization mechanism treats instances of a record class differently than ordinary serializable or externalizable objects. In particular, a record object is deserialized using the canonical constructor.

The body of a record declaration may contain constructor and member declarations as well as static initializers. But there are some restrictions as well:
1. It cannot contain an instance field declaration (static fields are allowed).
2. It cannot have an instance initializer (static initializers are allowed).
3. It cannot have abstract or native methods.

**Constructors and methods**
1. If a canonical constructor is not provided by the programmer explicitly, the compiler will provide one automatically with the same access modifier as that of the record itself. It takes the same arguments as the record components and initializes all the components. This is called the canonical constructor. See example below.
2. A programmer may provide the canonical constructor in regular form (just like the way you define a constructor for any regular class) or in a "compact form" like this:
```java
public record Student(int id, String name) { 
    public Student{ 
        if(id < 0) {
            throw new IllegalArgumentException();
        }
    }
}
```
3. After the last line of the compact constructor, all component fields of the record class are implicitly initialized to the values of the corresponding formal parameters specified in the call to new.
If you write a non-canonical constructor in a record explicitly then, on the first line of such a constructor, you must provide a call to either the canonical constructor or another constructor. For example:
```java
public record Student(int id, String name){
    public Student(){ //a non-canonical constructor
        this(10); //this line or a call to the canonical constructor is required
    }
    public Student(int id){ //another non-canonical constructor
        this(id, ""); //this line is required
    }
    public Student(int id, String name){ //regular form canonical constructor
        this.id = id; 
        this.name=name;
    }
}
```
4. An important difference between a record and a regular class with respect to constructors is that the compiler provides a canonical constructor for a record even when the programmer provides a non-canonical constructor and does not provide the canonical constructor. In a regular class, the compiler does not provide the default no-args constructor if the programmer provides any other constructor for the class.
5. A canonical constructor cannot be generic.
6. A canonical constructor cannot have a throws clause (not even a throws clause with unchecked exceptions is allowed) but a non-canonical constructor may have a throws clause.
7. Accessor methods must not throw any exceptions.
8. You may have other methods in a record as needed. In this respect, a record is like any other class.
9. It is a compile-time error for a record declaration to declare a record component with the name clone, finalize, getClass, hashCode, notify, notifyAll, toString, or wait. Observe that all these are public or protected methods of Object class

### Databases

When a connection is created, it is in auto-commit mode. i.e. auto-commit is enabled. This means that each individual SQL statement is treated as a transaction and is automatically committed right after it is completed. 
(A statement is completed when all of its result sets and update counts have been retrieved. In almost all cases, however, a statement is completed, and therefore committed, right after it is executed.)  
The way to allow two or more statements to be grouped into a transaction is to disable the auto-commit mode. Since it is enabled by default, you have to explicitly disable it after creating a connection by calling con.setAutoCommit(false);

To load a JDBC driver in JDBC 1.3, the application code would have to load the Driver class explicitly using Class.forName method, for example - Class.forName("com.xyz.jdbc.Driver"). However, with JDBC 4.0, applications no longer need to do this.\
There has never been any restriction on how many JDBC Drivers are allowed to be loaded by an application. If your application connects to say 3 different databases, you can load three different Drivers.

Applications no longer need to explicitly load JDBC drivers using Class.forName().  The DriverManager methods getConnection and getDrivers have been enhanced to support the Java Standard Edition Service Provider mechanism. JDBC 4.0 Drivers must include the file META-INF/services/java.sql.Driver. 
This file contains the name of the JDBC drivers implementation of java.sql.Driver. For example, to load the my.sql.Driver class, the META-INF/services/java.sql.Driver file would contain the entry:
``my.sql.Driver``\
When the method getConnection is called, the DriverManager will attempt to locate a suitable driver from amongst those loaded at initialization and those loaded explicitly using the same classloader as the current applet or application.

###Stored Procedures
java.sql.CallableStatement extends PreparedStatement and it is used to execute SQL stored procedures. It allows stored procedures to be called in a standard way for all RDBMSs.

Remember that in addition to having setXXX(i.e. setString, setDate, setInt etc.) and setObject methods with parameter index as the first parameter, (CallableStatement inherits these from PreparedStatement), the CallableStatement interface also has setXXX and setObject methods with parameter name as the first argument. 
For example:   callableStatement.setString("NAME", "john", java.sql.Types.VARCHAR);//valid\
callableStatement.setString(1, "john", java.sql.JDBCType.VARCHAR); //valid, //because it is inherited from PreparedStatement\
preparedStatement.setString("NAME", "john", java.sql.Types.VARCHAR); //will NOT compile\
preparedStatement.setString(1, "john", java.sql.Types.VARCHAR); //valid\
Note that the third argument can be an int (the ones defined in java.sql.Types) or a java.sql.JDBCType enum value (such as JDBCType.VARCHAR) because setObject is overloaded to accept either one.

###Packages and Classes
The modifier static pertains only to member classes, not to top level or local or anonymous classes. That is, only classes declared as members of top-level classes can be declared static. 
Package member classes, local classes (i.e. classes declared in methods) and anonymous classes cannot be declared static. Classes and variables can't be declared native. Only methods can be native.

###Switch
A switch works with the byte , short , char , and int primitive data types. It also works with enumerated types (discussed in Enum Types), the String class, and a few special classes that wrap certain primitive types: Character , Byte , Short , and Integer (discussed in Numbers and Strings). However,
Boolean, long , float , and double types are prohibited.

### Pattern Matching
Pattern Matching was introduced in Java 14.