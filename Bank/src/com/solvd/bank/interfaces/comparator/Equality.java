package com.solvd.bank.interfaces.comparator;

public class Equality implements IComparator {

    private Object o;
    private double value;

    public Equality(){}

    public Equality(Object o, double value) {
        this.o = o;
        this.value = value;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean compare(Object o) {
        return this.o.equals(o);
    }

}
