package com.techtangents.oneof.string;

public class Violin {
    public String removePrefix(String s, String prefix) {
        return s.startsWith(prefix)
                ? s.substring(prefix.length())
                : s;
    }
}