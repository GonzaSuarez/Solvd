package com.solvd.bank.interfaces.shiftmanager;

import com.solvd.bank.enums.Day;
import com.solvd.bank.people.Banker;

public class TakeBreak implements IShiftManager {

    private Banker banker;

    public TakeBreak(){}

    public TakeBreak(Banker banker) {
        this.banker = banker;
    }

    public Banker getBanker() {
        return banker;
    }

    public void setBanker(Banker banker) {
        this.banker = banker;
    }

    @Override
    public void manageShift(Day day) {
        if(day.isWeekend()) {
            //banker.sleep()
            //Here the banker stops working, for that I use the sleep method from Thread
        }
    }
}
