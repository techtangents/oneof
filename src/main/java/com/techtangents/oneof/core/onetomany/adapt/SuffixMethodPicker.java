package com.techtangents.oneof.core.onetomany.adapt;

import com.techtangents.oneof.core.string.Violin;

public class SuffixMethodPicker {
    final Violin violin = new Violin();

    public int pick(String methodName, String prefix) {
        String suffix = violin.removePrefix(methodName, prefix);
        return suffix.charAt(0) - 'A';
    }
}