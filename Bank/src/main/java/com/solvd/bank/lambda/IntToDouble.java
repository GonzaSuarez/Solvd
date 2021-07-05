package com.solvd.bank.lambda;

import java.util.function.IntToDoubleFunction;

public class IntToDouble {

    private int input;

    public IntToDouble(int input) {
        this.input = input;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public double calculate(IntToDoubleFunction function){
        return function.applyAsDouble(input);
    }
}
