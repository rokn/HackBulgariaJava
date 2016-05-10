package com.rokner;

import com.sun.media.sound.InvalidFormatException;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, InvalidFormatException {

        Polynomial poly = Polynomial.<Integer>fromString("3x^2 - 5x - 6");

        System.out.println(poly.toString());
    }
}