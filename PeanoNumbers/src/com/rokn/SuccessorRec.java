package com.rokn;

/**
 * Created by rokner on 5/12/16.
 */

public class SuccessorRec extends Natural {

    public SuccessorRec(Natural pr){this.pr = pr;}

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public Natural next() {
        return new Successor(this);
    }

    @Override
    public Natural prev() throws Exception {
        return pr;
    }

    @Override
    public Natural add(Natural b) throws Exception {
        if(b.isZero()){
            return this;
        }

        return next().add(b.prev());
    }

    @Override
    public Natural subtract(Natural b) throws Exception {
        if(b.isZero()){
            return this;
        }

        return prev().subtract(b.prev());
    }

    @Override
    public Integer toInt() throws Exception {
        return 1 + prev().toInt();
    }
}
