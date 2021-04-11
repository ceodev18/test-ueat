package com.ueat.roman;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Testing {
	private String input;
	private int expected;
	
	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { "X", 10 }});
	}

	public Testing(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before start tests");

	}

	@Test
    public void test() {
		ParseRomanToArabic parseRomanToArabic = new ParseRomanToArabic();
        assertEquals(expected, parseRomanToArabic.parseRomanNumber(input));
    }

}
