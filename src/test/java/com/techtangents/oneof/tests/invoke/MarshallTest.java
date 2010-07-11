package com.techtangents.oneof.tests.invoke;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.data.MarshallTarget;
import com.techtangents.oneof.types.type.OneOf3Type;
import com.techtangents.oneof.types.value.OneOf3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarshallTest {

    private final One one = new DefaultOne();

    @Test public void test() {
        check(new Frog(), "ribbit");
        check("my string", "my string");
        check(1234, "1234");
    }

    private void check(Object o, String expected) {
        OneOf3Type<Frog, String, Integer> t = one.of(Frog.class, String.class, Integer.class);
        OneOf3<Frog,String,Integer> v = t.nu(o);
        String actual = v.marshall(String.class, new MarshallTarget());
        assertEquals(expected, actual);
    }
}
