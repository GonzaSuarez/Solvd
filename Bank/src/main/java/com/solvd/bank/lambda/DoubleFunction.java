package com.solvd.bank.lambda;

import java.util.function.ToDoubleFunction;

public class DoubleFunction {

    private double input;

    public DoubleFunction(double input) {
        this.input = input;
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double calculate(ToDoubleFunction function){
        return function.applyAsDouble(input);
    }
}
