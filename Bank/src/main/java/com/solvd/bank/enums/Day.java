package com.solvd.bank.enums;

public enum Day {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend(){
        return this.name() == "SATURDAY" || this.name() == "SUNDAY";
    }
}
