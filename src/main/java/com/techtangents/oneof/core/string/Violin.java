package com.techtangents.oneof.core.string;

public class Violin {
    public String removePrefix(String s, String prefix) {
        return s.startsWith(prefix)
                ? s.substring(prefix.length())
                : s;
    }
}