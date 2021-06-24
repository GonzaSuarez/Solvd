package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyNameSearch implements ICurrencySearcher<Currency>{

    private String name;

    public CurrencyNameSearch(){}

    public CurrencyNameSearch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Currency> search(List<Currency> currencyList) {
        List<Currency> currencies = new ArrayList<>();
        for (Currency c: currencyList) {
            if(c.getName().equals(this.name)){
                currencies.add(c);
            }
        }
        return currencies;

    }
}
