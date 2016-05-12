package com.rokn;

public class Main {

    public static void main(String[] args) {
//        Natural five = new Successor(new Successor(new Successor(new Successor(new Successor(Zero.getInstance())))));
//        Natural five2 = new Successor(new Successor(new Successor(new Successor(new Successor(Zero.getInstance())))));

        Natural two = new SuccessorRec(new SuccessorRec(Zero.getInstance()));
        Natural two2 = new SuccessorRec(new SuccessorRec(Zero.getInstance()));

        try {
            System.out.println(two.subtract(two2).toInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
