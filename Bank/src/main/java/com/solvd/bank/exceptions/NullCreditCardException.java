package com.solvd.bank.exceptions;

public class CreditCardException extends Exception{

    public CreditCardException(){}

    public CreditCardException(String errorMessage, Throwable error){
        super(errorMessage,error);
    }
}
