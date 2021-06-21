package com.solvd.bank.exceptions;

public class NullCurrencyException extends Exception {

    public NullCurrencyException(){}
    public NullCurrencyException(String errorMessage){
        super(errorMessage);

    }

}
