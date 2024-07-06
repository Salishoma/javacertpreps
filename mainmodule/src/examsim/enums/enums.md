###Enums
Enums can be defined inside a class with any access modifier, an enum defined inside a class can be static. There can be more than one enums in a class.
An enum cannot be defined in a constructor or method. Enum constructor is always private, you cannot make it public or protected. If an enum has no
constructor declaration, then a private constructor that takes no parameter is actually provided. 

You cannot extend an enum or class because enum implicitly extends java.lang.Enum. But an enum can implement interface.
An enum can't be cloned since it maintains exactly one instance of its constants. Also, you cannot override its clone method because java.lang.Enum makes it final.
The natural order of the enum values is the order in which they are defined. i.e. in the order of their ordinal value. It has method
ordinal() which returns the index(starting with 0) of that constant. i.e. the position of that constant in its enum declaration