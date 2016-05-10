package com.rokner;

import com.sun.media.sound.InvalidFormatException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antonio Mindov on 5/11/2016.
 */

public class Polynomial<T extends Number> {

    private Map<Integer, T> coefficients;

    private Polynomial() {
        coefficients = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        coefficients.forEach((k,v) -> buffer.append(v.toString() + ((k > 0) ? "x^" + k.toString() : "") + " "));

        return buffer.toString();
    }

    public static <T extends Number> Polynomial<T> fromString(String polynomial) throws ParseException, InvalidFormatException {
        Polynomial<T> poly = new Polynomial<>();

        StringBuffer buffer = new StringBuffer(polynomial.replaceAll("\\s+", ""));
        String secondary;
        Integer power;
        T coefficient;
        boolean parsed = false;

        int nextSign;
        do {
            nextSign = -1;

            for (int i = 1; i < buffer.length(); i++) {
                if (buffer.charAt(i) == '+' || buffer.charAt(i) == '-') {
                    nextSign = i;
                    break;
                }
            }

            if(nextSign < 0){
                parsed = true;
                nextSign = buffer.length();
            }

            secondary = buffer.substring(0, nextSign);
            buffer = new StringBuffer(buffer.substring(nextSign));
            int xPos = secondary.indexOf("x");
            int powerPos = secondary.indexOf("^");

            if(xPos >= 0){
                if(powerPos > 0){
                    power = Integer.parseInt(secondary.substring(powerPos + 1));
                } else {
                    power = 1;
                }
            }
            else {
                power = 0;
                xPos = secondary.length();
            }

            coefficient = (T) NumberFormat.getInstance().parse(secondary.substring(0,xPos));

            if(poly.coefficients.containsKey(power)){
                throw new InvalidFormatException();
            } else {
                poly.coefficients.put(power, coefficient);
            }

        }while(!parsed);

        return poly;
    }
}
