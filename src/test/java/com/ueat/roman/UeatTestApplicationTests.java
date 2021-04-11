package com.ueat.roman;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UeatTestApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(UeatTestApplicationTests.class);
	private static ParseRomanToArabic parseRomanToArabic = new ParseRomanToArabic();
@BeforeClass
public static void setup(){
	System.out.println("testing");
}
	@Test
	void testValidationNumberSuccess() {
		Assertions.assertTrue(parseRomanToArabic.validate("I"));
		Assertions.assertTrue(parseRomanToArabic.validate("V"));
		Assertions.assertTrue(parseRomanToArabic.validate("X"));
		Assertions.assertTrue(parseRomanToArabic.validate("L"));
		Assertions.assertTrue(parseRomanToArabic.validate("C"));
		Assertions.assertTrue(parseRomanToArabic.validate("D"));
		Assertions.assertTrue(parseRomanToArabic.validate("M"));

		Assertions.assertTrue(parseRomanToArabic.validate("XXI"));
		Assertions.assertTrue(parseRomanToArabic.validate("XL"));
		Assertions.assertTrue(parseRomanToArabic.validate("LVIII"));
		

	}

	@Test
	void testValidationNumberFail() {
		Assertions.assertFalse(parseRomanToArabic.validate("LL"));
		Assertions.assertFalse(parseRomanToArabic.validate("MMMM"));
		Assertions.assertFalse(parseRomanToArabic.validate("CMCM"));

	}

	@Test
	void testParseNumberSuccess() {
		
		Assertions.assertEquals(55, parseRomanToArabic.parseRomanNumber("LV"));
		Assertions.assertEquals(21, parseRomanToArabic.parseRomanNumber("XXI"));
		Assertions.assertEquals(40, parseRomanToArabic.parseRomanNumber("XL"));
		Assertions.assertEquals(58, parseRomanToArabic.parseRomanNumber("LVIII"));

	}

	@Test
	void testParseNumberFail() {
		parseRomanToArabic = new ParseRomanToArabic();

		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber("MMMM"));
		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber(""));
		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber(null));
	}
	@Test
	void main() {
		assertDoesNotThrow(() -> UeatTestApplication.main(new String[]{"x","XXI"}));
	}
}