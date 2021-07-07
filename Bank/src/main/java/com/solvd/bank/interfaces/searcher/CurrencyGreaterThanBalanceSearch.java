package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyGreaterThanBalanceSearch implements ISearcher<Currency, Double> {

    public CurrencyGreaterThanBalanceSearch(){}

    @Override
    public List<Currency> search(List<Currency> currencyList, Double value) {
        List<Currency> list = new ArrayList<>();
        list.stream().forEach((currency -> {
            if(currency.getAmmount() >= value){list.add(currency);}
        }));
        return list;
    }
}
