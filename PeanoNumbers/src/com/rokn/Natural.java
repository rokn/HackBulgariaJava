package com.rokn;

import java.util.Objects;

/**
 * Created by rokner on 5/12/16.
 */
public abstract class Natural {
    protected Natural pr;

    public abstract boolean isZero();
    public abstract Natural next();
    public abstract Natural prev() throws Exception;
    public abstract Natural add(Natural b);
    public abstract Natural subtract(Natural b) throws Exception;
    public abstract Integer toInt();

    @Override
    public boolean equals(Object o) {
        Natural other = (Natural) o;

        return other != null && Objects.equals(other.toInt(), toInt());

    }
}
