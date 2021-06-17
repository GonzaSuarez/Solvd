package com.solvd.bank.interfaces.calculator;

import com.solvd.bank.paymethods.Currency;

public class Addition implements ICalculator {

    private double value;

    public Addition(){}

    public Addition(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double calculate(Currency currency) {
        return currency.getAmmount() + this.value;
    }
}
