package com.rokner;

import com.sun.media.sound.InvalidFormatException;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, InvalidFormatException {

        Polynomial poly = Polynomial.<Integer>fromString("3x^2 + 5x + 6");

        Polynomial poly2 = Polynomial.<Integer>fromString("6x^3 - 2x^2 + 10x + 12");

        System.out.println(poly.subract(poly2).toString());
    }
}