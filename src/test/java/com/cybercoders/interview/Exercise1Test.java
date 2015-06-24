package com.cybercoders.interview;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Exercise1Test {
    @Test
    public void testReverseString() throws Exception {
        assertThat(Exercise1.reverseString("Hello World!"), is("!dlroW olleH"));
    }
}