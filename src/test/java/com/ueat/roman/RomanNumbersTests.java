package com.ueat.roman;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RomanNumbersTests {

	private static final Logger logger = LoggerFactory.getLogger(RomanNumbersTests.class);
	private static ParseRomanToArabic parseRomanToArabic;
	private static final int FAIL = -1;
	@BeforeClass
	public static void setUpBeforeClass() {
		logger.info("Init config");
		parseRomanToArabic = new ParseRomanToArabic();
	}

	@Test
	public void validationNumberSuccess() {

		Assertions.assertTrue(parseRomanToArabic.validate("X"));
		Assertions.assertTrue(parseRomanToArabic.validate("XL"));
		Assertions.assertTrue(parseRomanToArabic.validate("LVIII"));

	}

	@Test
	public void validationNumberFail() {

		Assertions.assertFalse(parseRomanToArabic.validate("MMMM"));

	}

	@Test
	public void parseNumberSuccess() {

		Assertions.assertEquals(21, parseRomanToArabic.parseRomanNumber("XXI"));
		Assertions.assertEquals(40, parseRomanToArabic.parseRomanNumber("XL"));
		Assertions.assertEquals(58, parseRomanToArabic.parseRomanNumber("LVIII"));

	}

	@Test
	public void parseNumberWrongFormat() {
		Assertions.assertEquals(FAIL, parseRomanToArabic.parseRomanNumber("XXCDD"));

	}

	@Test
	public void parseNumberEmpty() {
		Assertions.assertEquals(FAIL, parseRomanToArabic.parseRomanNumber(""));

	}

	@Test
	public void parseNumberNull() {
		Assertions.assertEquals(FAIL, parseRomanToArabic.parseRomanNumber(null));
	}

	@Test
	public void main() {
		assertDoesNotThrow(() -> UeatTestApplication.main(new String[] {}));
	}
}