package com.solvd.bank.exceptions;

public class CurrencyException extends Exception {

    public CurrencyException(){}
    public CurrencyException(String errorMessage, Throwable error){
        super(errorMessage, error);

    }

}
