package com.rokn;

public class Main {

    public static void main(String[] args) {
        Natural five = new Successor(new Successor(new Successor(new Successor(new Successor(Zero.getInstance())))));
        Natural five2 = new Successor(new Successor(new Successor(new Successor(new Successor(Zero.getInstance())))));

        System.out.println(five.add(five2).toInt());
    }
}
