package com.ueat.roman;
import java.util.Map;
public class Global {
    /*  REGULAR EXPRESSION
        WHY?
        M{0,3} at the beginning of the string max MMM
        (CM|CD|D?C{0,3}) once of  CM or CD or D or max CCC
        (XC|XL|L?X{0,3}) once of  XC or XL or L or max XXX
        (IX|IV|V?I{0,3}) once of  IX or IV or V or max III
        .
     */

    public static final String DETECTION_PATTERN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    //MAPPING EACH ROMAN LETTER
    public static final Map < Character, Integer > FROM_ROMAN = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    //MESSAGES SECTION
    public static final int WRONG_FORMAT = -1;
    public static final String ADD_NUMBER = "Enter a roman number: ";
    public static final String STOP = "Type 'exit' to stop. ";
    public static final String VALIDATE = "Validate your roman number";
    public static final String SHOW_RESULT = "After parse, the result is: ";

}