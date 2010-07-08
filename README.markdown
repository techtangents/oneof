OneOf
-----

Java library that provides support for what I call a 'switched' data type. So, what do I mean by this?

A switched data type is a type that has a value of one of a set of types.

Say, I have a value which may be a String, Integer or Foo. I could represent this in a few different ways:

1. Loosely-typed as an object. This leads to class cast exceptions on access, instanceof checks, plus it could hold any value.
2. class X { String s; Integer i; Foo f; }. This is hard to genericise, and you have to deal with nulls.
3. Map of the superset of the properties of each class. Only really useful if the types only differ on a few fields.
4. OneOf

Using OneOf, you'd do something like this:

    OneOf one = new DefaultOneOf();
    Object myobject = getMyObjectFromSomewhere();
    OneOf<String, Integer, Foo> o = one.of(myobject, String.class, Integer.class, Foo.class)

Under the hood, we're still storing as an Object. However:

- the type of the object is validated earlier. It's validated upon creation of the oneOf, which is earlier than a cast on the way out.
- it's also validated upon access, if you use get(Class)
- type-checking is encapsulated

Future Plans
============

Handlers
--------

I'd like to be able to use the OneOf to switch on types and delegate to various handlers.

e.g. something along these lines... (yeah, it probably doesn't compile, just brainstorming)

    OneOf oneof = one.of(myobject, String.class, Integer.class);
    interface Handler<I, O> { O handle(I in); }
    class MyStringHandler implements Handler<String, Something>...
    class MyIntegerHandler implements Handler<Integer, Something>...

    Map<Class, Handler<?, T>> m = new Map<Class, Handler>();
    m.put(String.class, new MyStringHandler());
    m.put(Integer.class, new MyIntegerHandler());  

    Something s = oneof.invoke(m);

Or similar:

    Class handler {
       Something handle(String s) {...}
       Something handle(Integer i) {...}

There's a few other options with some more reflecty magic.

Types
-----

I'd like to separate the creation of a switched type from the instantiation.

e.g.

    OneOfType<String, Integer> myType = one.of(String.class, Integer.class);
    OneOfValue<String Integer> myValue = myType.nu(myobject);

myType.nu would do the type validation.