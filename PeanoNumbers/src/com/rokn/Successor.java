package com.rokn;

/**
 * Created by rokner on 5/12/16.
 */
public class Successor extends Natural {

    public Successor(Natural pr){
        this.pr = pr;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public Natural next() {
        return new Successor(this);
    }

    @Override
    public Natural prev() {
        return this.pr;
    }

    @Override
    public Natural add(Natural b) {
        Natural res = this;
        Natural curr = this;

        while(!curr.isZero()){
            res = new Successor(res);
            try {
                curr = curr.prev();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public Natural subtract(Natural b) throws Exception {
        Natural res = this;
        Natural curr = this;

        while(!curr.isZero()){
            res = new Successor(res.prev().prev());
            try {
                curr = curr.prev();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public Integer toInt() {
        Integer intForm = 0;
        Natural curr = this;

        while(!curr.isZero()){
            intForm++;
            try {
                curr = curr.prev();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return intForm;
    }

    @Override
    public String toString() {
        return "Succ + " + prev().toString();
    }
}
