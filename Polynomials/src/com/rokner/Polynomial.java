package com.rokner;

import com.sun.media.sound.InvalidFormatException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Antonio Mindov on 5/11/2016.
 */

public class Polynomial<T extends Number> {

    private NavigableMap<Integer, T> coefficients;

    private Polynomial() {
        coefficients = new TreeMap<>();
    }

    public Polynomial<T> add(Polynomial<T> other){
        Polynomial<T> res = new Polynomial<>();

        res.coefficients.putAll(coefficients);

        for (Map.Entry<Integer, T> entry : other.coefficients.entrySet()) {
            if(res.coefficients.containsKey(entry.getKey())){
                res.coefficients.put(entry.getKey(), (T)(new Double(res.coefficients.get(entry.getKey()).doubleValue() + entry.getValue().doubleValue())));
            } else {
                res.coefficients.put(entry.getKey(), entry.getValue());
            }
        }

        return res;
    }

    public Polynomial<T> subtract(Polynomial<T> other){
        Polynomial<T> res = new Polynomial<>();

        res.coefficients.putAll(coefficients);

        for (Map.Entry<Integer, T> entry : other.coefficients.entrySet()) {
            if(res.coefficients.containsKey(entry.getKey())){
                res.coefficients.put(entry.getKey(), (T)(new Double(res.coefficients.get(entry.getKey()).doubleValue() - entry.getValue().doubleValue())));
            } else {
                res.coefficients.put(entry.getKey(), entry.getValue());
            }
        }

        return res;
    }

    public Polynomial<T> multiply(Polynomial<T> other){
        Polynomial<T> res = new Polynomial<>();

        res.coefficients.putAll(coefficients);

        for (Map.Entry<Integer, T> entry : other.coefficients.entrySet()) {
            if(res.coefficients.containsKey(entry.getKey())){
                res.coefficients.put(entry.getKey(), (T)(new Double(res.coefficients.get(entry.getKey()).doubleValue() + entry.getValue().doubleValue())));
            } else {
                res.coefficients.put(entry.getKey(), entry.getValue());
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        boolean first = true;

        for (Map.Entry<Integer, T> entry : coefficients.descendingMap().entrySet()) {
            if(!first) {
                if(entry.getValue().doubleValue() > 0){
                    buffer.append("+");
                }
            } else {
                first = false;
            }

            buffer.append(entry.getValue().toString())
                    .append((entry.getKey() > 0) ? "x^" + entry.getKey().toString() : "")
                    .append(" ");
        }

        return buffer.substring(0, buffer.length() - 1);
    }

    public static <T extends Number> Polynomial<T> fromString(String polynomial) throws ParseException, InvalidFormatException {
        Polynomial<T> poly = new Polynomial<>();

        StringBuffer buffer = new StringBuffer(polynomial.replaceAll("\\s+", ""));
        String secondary;
        Integer power;
        T coefficient;
        boolean parsed = false;
        boolean isAddition;

        int nextSign;
        do {
            isAddition = false;
            nextSign = -1;

            for (int i = 1; i < buffer.length(); i++) {
                if (buffer.charAt(i) == '+' || buffer.charAt(i) == '-') {
                    nextSign = i;

                    if(buffer.charAt(i) == '+'){
                        isAddition = true;
                    }

                    break;
                }
            }

            if(nextSign < 0){
                parsed = true;
                nextSign = buffer.length();
            }

            secondary = buffer.substring(0, nextSign);

            if(isAddition){
                nextSign++;
            }

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
                poly.coefficients.put(power, (T)(new Double(poly.coefficients.get(power).doubleValue() + coefficient.doubleValue())));
            } else {
                poly.coefficients.put(power, coefficient);
            }

        }while(!parsed);

        return poly;
    }
}
