package com.solvd.bank.exceptions;

public class WrongNameException extends Exception{

    public WrongNameException(){}

    public WrongNameException(String errorMessage){
        super(errorMessage);
    }
}
