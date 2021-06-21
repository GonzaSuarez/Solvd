package com.solvd.bank.exceptions;

public class NullCreditCardException extends Exception{

    public NullCreditCardException(){}

    public NullCreditCardException(String errorMessage){
        super(errorMessage);
    }
}
