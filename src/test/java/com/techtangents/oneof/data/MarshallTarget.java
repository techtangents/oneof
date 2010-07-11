package com.techtangents.oneof.data;

@SuppressWarnings("unused")
public class MarshallTarget {
    public String stringThing(String input) { return input; }
    public String integerThing(Integer input) { return input.toString(); }
    public String frogThing(Frog input) { return input.toString();}
}
