package com.techtangents.oneof.api;

import com.techtangents.oneof.iface.*;

public interface OneOf {
    <A> OneOf1<A> of(Object o, Class<A> classA);

    <A, B> OneOf2<A, B> of(Object o, Class<A> classA, Class<B> classB);

    <A, B, C> OneOf3<A, B, C> of(Object o, Class<A> classA, Class<B> classB, Class<C> classC);

    <A, B, C, D> OneOf4<A, B, C, D> of(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD);

    <A, B, C, D, E> OneOf5<A, B, C, D, E> of(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE);
}
