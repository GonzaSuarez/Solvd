package com.solvd.bank.enums;

public enum Office {
    ACCOUNTING("Accounting"), PUBLICSERVICE("PublicService"), SECURITY("Security");

    private String name;

    Office(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
