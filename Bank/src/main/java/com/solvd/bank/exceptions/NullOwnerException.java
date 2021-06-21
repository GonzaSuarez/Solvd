package com.solvd.bank.exceptions;

public class NullOwnerException extends Exception{

    public NullOwnerException(){}

    public NullOwnerException(String errorMessage){
        super(errorMessage);
    }
}
