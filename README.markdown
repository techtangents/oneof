OneOf
-----

Java library that lets you create "OneOf" objects, which provide similar functionality to Algebraic Data Types found in languages like Haskell.
A OneOf stores a value, whose type is one of a specified set of types.

You can create a OneOf "type" by specifying the set of types, then use that "type" to create instances. Alternatively, you can create the type and instance in one hit.

Example
-------

Say, I have a value which may be a String, Integer or Foo.

Using OneOf, you'd do something like this:

    One one = new DefaultOne();
    Object myobject = getMyObjectFromSomewhere();
    OneOf3Type<String, Integer, Foo> type = one.of(String.class, Integer.class, Foo.class);
    OneOf3<String, Integer, Foo> o = type.nu(myobject);

You can also create the type and value on one step

    OneOf one = new DefaultOneOf();
    Object myobject = getMyObjectFromSomewhere();
    OneOf3<String, Integer, Foo> o = one.nu(myobject, String.class, Integer.class, Foo.class)

Under the hood, we're still storing as an Object. However:

- the type of the object is validated earlier. It's validated upon creation of the oneOf, which is earlier than a cast on the way out.
- it's also validated upon access, if you use get(Class)
- type-checking is encapsulated
- you can invoke methods based on the type, without doing type-checking yourself


Invoking
--------

You can use a OneOf to invoke one of a set of functions, depending on its type.
Say I have an object and want to run one method if it's a String, but a different one if it's an Integer.

    Object x = "hello";

    Fn<String, String> fnString = new Fn<String, String>() {
        public String apply(String s) {
            return "it's a string";
        }
    };
    Fn<Integer, String> fnInteger = new Fn<Integer, String>() {
        public String apply(Integer s) {
            return "it's an integer: " + s.toString();
        }
    };


    OneOf2Type<String, Integer> t = ONE.of(String.class, Integer.class);
    OneOf2<String, Integer> v = t.nu(x);
    String result = v.invoke(fnString, fnInteger);

    System.out.println("result = " + result);


For this simple example, type-checking would have been less code.
However, type-checking can lead to messy code that's hard to refactor.
As the code grows, you may want to encapsulate the type-checking and use strategy 
pattern to encapsulate the actions for each type. OneOf takes you there straight away.

Tip: In IntelliJ, turn on the setting "Editor -> Code Folding -> Collapse by Default -> closures".
This makes IntelliJ collapse the Fn instances down to something much more readable.

Marshalling
-----------

"marshall" is like "invoke", except it's type-switched on method, rather than object.
In the below example, the value is a String, so the method "stringThing" is invoked.

    public class MarshallDemo {
        private static final One one = new DefaultOne();

        public static class MyInvokee {
            public String stringThing(String input) { return "was a string"; }
            public String integerThing(Integer input) { return "was an integer"; }
        }

        public static void main(String[] args) {
            Object invokee = new MyInvokee();
            OneOf2Type<Integer, String> t = one.of(Integer.class, String.class);
            OneOf2<Integer, String> v = t.nu("some string");
            String output = v.marshall(String.class, invokee);
            System.out.println("output = " + output);
        }
    }

Note: the invokee classes must be public and cannot be inner classes, otherwise OneOf can't
reflect their members.

Future plans
------------

The 'Fn' interface above could be replaced by the Functional Java 'F' interface.
