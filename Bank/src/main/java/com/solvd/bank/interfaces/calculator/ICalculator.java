package com.solvd.bank.interfaces.calculator;

import com.solvd.bank.paymethods.Currency;

public interface ICalculator<T> {

    double calculate(T value);
}
