package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyNameSearch implements ISearcher<Currency, String>{


    public CurrencyNameSearch(){}


    @Override
    public List<Currency> search(List<Currency> currencyList, String name) {
        List<Currency> currencies = new ArrayList<>();
        for (Currency c: currencyList) {
            if(c.getName().equals(name)){
                currencies.add(c);
            }
        }
        return currencies;

    }
}
