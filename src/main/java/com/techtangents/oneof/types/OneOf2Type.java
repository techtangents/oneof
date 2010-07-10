package com.techtangents.oneof.types;

import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.switchmap.types.SwitchMap2;
import com.techtangents.oneof.values.OneOf2;

public interface OneOf2Type<A, B> {
    OneOf2<A, B> nu(Object o);

    <Out> SwitchMap2<Out, A, B> switchMap(Fn<A, Out> a, Fn<B, Out> b);
}
