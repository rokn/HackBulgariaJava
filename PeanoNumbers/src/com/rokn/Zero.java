package com.rokn;

import java.io.InvalidClassException;

/**
 * Created by rokner on 5/12/16.
 */
public class Zero extends Natural{

    private static Zero instance = new Zero();

    private Zero(){
    }

    @Override
    public boolean isZero() {
        return true;
    }

    @Override
    public Natural next() {
        return new Successor(this);
    }

    @Override
    public Natural prev() throws Exception {
        throw new Exception("There is no prev on zero");
    }

    @Override
    public Natural add(Natural b) {
        return null;
    }

    @Override
    public Natural subtract(Natural b) throws Exception {
        throw new Exception("There is no prev on zero");
    }

    @Override
    public Integer toInt() {
        return 0;
    }

    public static Zero getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Zero";
    }
}
