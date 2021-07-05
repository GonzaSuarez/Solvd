package com.solvd.bank.enums;

public enum CreditCardProvider {

    VISA("Visa", 4547), MASTERCARD("MasterCard", 4040), CABAL("Cabal", 5050);

    private String name;
    private int headNumber;

    private CreditCardProvider(String name, int headNumber){
        this.name = name;
        this.headNumber = headNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - HeadNumber: " + headNumber;
    }

    public String getName() {
        return name;
    }

    public int getHeadNumber() {
        return headNumber;
    }


}
