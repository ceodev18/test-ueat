package com.ueat.roman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseRomanToArabic {

    public boolean validate(String number) {

        if (number == null || number.isBlank() || number.isEmpty())return false;
        Pattern pattern = Pattern.compile(Global.DETECTION_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        return matcher.find();

    }

    public int parseRomanNumber(String number) {

        if (!validate(number)) {
        	return -1;
        }

        int parsed = 0, prev = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            int temp = Global.FROM_ROMAN.get(number.charAt(i));
            if (temp < prev)
                parsed -= temp;
            else
                parsed += temp;
            prev = temp;
        }
        
        return parsed;

    }

}