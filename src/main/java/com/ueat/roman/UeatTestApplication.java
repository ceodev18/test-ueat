package com.ueat.roman;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UeatTestApplication{

	public static void main(String[] args) {
		SpringApplication.run(UeatTestApplication.class, args);
        ParseRomanToArabic parser = new ParseRomanToArabic();
        int result = parser.parseRomanNumber(args[1]);
        System.out.println(result == Global.WRONG_FORMAT ? Global.VALIDATE : Global.SHOW_RESULT + result);
	}


}