package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyGreaterThanBalanceSearch implements ICurrencySearcher {

    private double value;

    public CurrencyGreaterThanBalanceSearch(){}

    public CurrencyGreaterThanBalanceSearch(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public List<Currency> search(List<Currency> currencyList) {
        List<Currency> list = new ArrayList<>();
        for (Currency c: currencyList) {
            if(c.getAmmount() >= this.value){
                list.add(c);
            }
        }
        return list;
    }
}
