package com.techtangents.oneof.invoke;

public interface Fn<In, Out> {
    Out apply(In in);
}
