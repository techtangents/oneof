package com.techtangents.oneof.api;

import com.techtangents.oneof.iface.*;

public interface OneOf {
    <A> OneOf1<A> nu(Object o, Class<A> classA);

    <A, B> OneOf2<A, B> nu(Object o, Class<A> classA, Class<B> classB);

    <A, B, C> OneOf3<A, B, C> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC);

    <A, B, C, D> OneOf4<A, B, C, D> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD);

    <A, B, C, D, E> OneOf5<A, B, C, D, E> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE);
}
