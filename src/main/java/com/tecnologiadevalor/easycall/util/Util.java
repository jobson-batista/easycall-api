package com.tecnologiadevalor.easycall.util;

public class Util {

    public boolean isNumeric(String text) {
        // Regex that validates if the string has only numbers
        return text != null && text.matches("\\d+");
    }
}
