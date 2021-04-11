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

	private static Logger logger = LoggerFactory.getLogger(RomanNumbersTests.class);
	private static ParseRomanToArabic parseRomanToArabic;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

		Assertions.assertFalse(parseRomanToArabic.validate("LL"));
		Assertions.assertFalse(parseRomanToArabic.validate("MMMM"));
		Assertions.assertFalse(parseRomanToArabic.validate("CMCM"));

	}

	@Test
	public void parseNumberSuccess() {
		Assertions.assertEquals(21, parseRomanToArabic.parseRomanNumber("XXI"));
		Assertions.assertEquals(40, parseRomanToArabic.parseRomanNumber("XL"));
		Assertions.assertEquals(58, parseRomanToArabic.parseRomanNumber("LVIII"));

	}

	@Test
	public void parseNumberWrongFormat() {
		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber("MMMMM"));

	}

	@Test
	public void parseNumberEmpty() {
		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber(""));

	}

	@Test
	public void parseNumberNull() {
		Assertions.assertEquals(-1, parseRomanToArabic.parseRomanNumber(null));
	}

	@Test
	public void main() {
		assertDoesNotThrow(() -> UeatTestApplication.main(new String[] { "X", "XXI" }));
	}
}